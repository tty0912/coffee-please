package model.service;

import java.sql.SQLException;

import model.member.BuyerDAO;
import model.member.SellerDAO;
import model.order.OrderProductDAO;
import model.order.OrderProductDO;
import model.order.OrderProductDetailDAO;
import model.order.OrderProductDetailDO;
import model.product.BeansDAO;
import model.product.BeansDO;

public class OrderService {

    BuyerDAO buyerDAO = new BuyerDAO();
    SellerDAO sellerDAO = new SellerDAO();
    BeansDAO beansDAO = new BeansDAO();
    OrderProductDAO orderProductDAO = new OrderProductDAO();
    OrderProductDetailDAO orderProductDetailDAO = new OrderProductDetailDAO();


    // 상품 즉시 구매
    public boolean onlyOnePayment(int beansNum, int qty, String buyerEmail) throws SQLException {

        BeansDO bean = beansDAO.getBean(beansNum);
        long totalPrice = (long) bean.getBeanPrice() * qty;
        long buyerPoint = checkPoint(buyerEmail);

        if(buyerPoint >= totalPrice){
            movePoint(bean.getSellerEmail(), buyerEmail, totalPrice);

            insertOrderProductDAO(buyerPoint, totalPrice, buyerEmail);
            insertOrderProductDetailDAO(buyerEmail, beansNum, qty);

            return true;
        }
        else return false;
    }

    //장바구니 결제
    public boolean cartPayment(){

        return true;
    }


    // 포인트 확인
    public long checkPoint(String email){

        long buyerPoint = buyerDAO.checkBuyerPoint(email);
        return buyerPoint;
    }

    // 구매자 포인트 차감 + 판매자 포인트 증가
    public void movePoint(String sellerEmail, String buyerEmail, long point){
        buyerDAO.buyerPointUpdate(buyerEmail, point);
        sellerDAO.sellerPointUpdate(sellerEmail, point);
        System.out.println(sellerEmail);
    }

    public boolean insertOrderProductDAO(long point, long price, String buyerEmail) throws SQLException {

        OrderProductDO orderProductDO = new OrderProductDO();
        orderProductDO.setBuyerEmail(buyerEmail);
        orderProductDO.setOrderTotalPrice(price);
        orderProductDO.setBeforeOrderPoint(point);

        orderProductDAO.insertOrderProduct(orderProductDO);

        return true;
    }
    public boolean insertOrderProductDetailDAO(String email, int num, int qty) throws SQLException {

        OrderProductDetailDO orderProductDetailDO = new OrderProductDetailDO();
        orderProductDetailDO.setBuyerEmail(email);
        orderProductDetailDO.setBeansNum(num);
        orderProductDetailDO.setQty(qty);

        orderProductDetailDAO.insertOrderProductDetail(orderProductDetailDO);
        return true;
    }

}

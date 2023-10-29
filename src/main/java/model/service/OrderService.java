package main.java.model.service;

import main.java.model.member.BuyerDAO;
import main.java.model.member.SellerDAO;
import main.java.model.order.OrderProductDO;
import main.java.model.product.BeansDAO;
import main.java.model.product.BeansDO;
import org.springframework.stereotype.Service;

public class OrderService {

    BuyerDAO buyerDAO = new BuyerDAO();
    SellerDAO sellerDAO = new SellerDAO();
    BeansDAO beansDAO = new BeansDAO();


    // 상품 즉시 구매
    public boolean onlyOnePayment(int beansNum, int qty, String buyerEmail) {

        BeansDO bean = beansDAO.getBean(beansNum);
        int totalPrice = bean.getBeanPrice() * qty;

        if(checkPoint(buyerEmail, totalPrice)){
            movePoint(bean.getSellerEmail(), buyerEmail, totalPrice);
            return true;
        }
        else return false;
    }

    //장바구니 결제
    public boolean cartPayment(){

        return true;
    }


    // 포인트 확인
    public boolean checkPoint(String email, long price){

        long buyerPoint = buyerDAO.checkBuyerPoint(email);
        return buyerPoint >= price;
    }

    // 구매자 포인트 차감 + 판매자 포인트 증가
    public void movePoint(String sellerEmail, String buyerEmail, long point){
        buyerDAO.buyerPointUpdate(buyerEmail, point);
        sellerDAO.sellerPointUpdate(sellerEmail, point);
    }

}

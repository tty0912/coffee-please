package main.java.model.service;

import main.java.model.member.BuyerDAO;
import main.java.model.member.SellerDAO;
import main.java.model.order.OrderProductDO;
import org.springframework.stereotype.Service;

public class OrderService {

    BuyerDAO buyerDAO = new BuyerDAO();
    SellerDAO sellerDAO = new SellerDAO();


//    public void onlyOnePayment(int beansNum, int qyt, String buyerEmail) {
//
//        long point = buyerDAO.checkBuyerPoint(buyerEmail);
//
//        //구매자 포인트 차감 + 판매자 포인트 증가
//        if (point >= beansPrice * qyt){
//            buyerDAO.buyerPointUpdate(buyerEmail,beansPrice*qyt);
//            sellerDAO.sellerPointUpdate()
//        }
//        //
//    }
}

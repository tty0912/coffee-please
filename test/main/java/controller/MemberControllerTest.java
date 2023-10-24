package main.java.controller;

import main.java.model.member.BuyerDAO;
import main.java.model.member.BuyerDO;
import main.java.model.member.SellerDAO;
import main.java.model.member.SellerDO;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class MemberControllerTest {

    SellerDAO sellerDAO = new SellerDAO();
    BuyerDAO buyerDAO = new BuyerDAO();


    @Test
    public void insertSellerTest() throws Exception {

        SellerDO sellerDO = new SellerDO();

        sellerDO.setSellerEmail("longlee@daum.net");
        sellerDO.setBusinessName("상호명");
        sellerDO.setBusinessNum(12345);
        sellerDO.setNickname("longlee");
        sellerDO.setPasswd("1234qwer");
        sellerDO.setTel(123);
        sellerDO.setAddress("부산시 사상구");

        assertThat(sellerDAO.insertSeller(sellerDO)).isEqualTo(1);
    }

    @Test
    public void updateSellerTest(){

        SellerDO sellerDO = new SellerDO();

        sellerDO.setNickname("류현진");
        sellerDO.setTel(1111);
        sellerDO.setAddress("부산시 북구");
        sellerDO.setSellerImg("img-url");
        sellerDO.setSellerEmail("longlee@daum.net");

        assertThat(sellerDAO.updateSeller(sellerDO)).isEqualTo(1);
    }


    @Test
    public void getSellerTest(){

        SellerDO seller = sellerDAO.getSeller("longlee@daum.net");

        assertThat(seller.getBusinessName()).isEqualTo("상호명");
        assertThat(seller.getBusinessNum()).isEqualTo(12345);
        assertThat(seller.getNickname()).isEqualTo("류현진");
        assertThat(seller.getPasswd()).isEqualTo("1234qwer");
        assertThat(seller.getPoint()).isEqualTo(0);
        assertThat(seller.getTel()).isEqualTo(1111);
        assertThat(seller.getSellerImg()).isEqualTo("img-url");
        assertThat(seller.getAddress()).isEqualTo("부산시 북구");
//        assertThat(seller.getRegdate()).isEqualTo(1111);

    }

    @Test
    public void deleteSellerTest(){

        assertThat(sellerDAO.deleteSeller("longlee@daum.net")).isEqualTo(1);
    }

    @Test
    public void insertBuyerTest() throws Exception {

        BuyerDO buyer = new BuyerDO();

        buyer.setBuyerEmail("hmson@naver.com");
        buyer.setBuyerName("손흥민");
        buyer.setNickname("흥민흥민");
        buyer.setPasswd("qqqqwwww");
        buyer.setTel(111222);
        buyer.setAddress("부산시 남구");
        buyer.setPoint(1000000);

        assertThat(buyerDAO.insertBuyer(buyer)).isEqualTo(1);
    }

    @Test
    public void updateBuyerTest(){

        BuyerDO buyer = new BuyerDO();

        buyer.setNickname("흥민흥민흥민");
        buyer.setTel(777777);
        buyer.setAddress("부산시 부산진구");
        buyer.setBuyerImg("buyerImg-url");
        buyer.setBuyerEmail("hmson@naver.com");

        assertThat(buyerDAO.updateBuyer(buyer)).isEqualTo(1);

    }

    @Test
    public void getBuyerTest(){

        BuyerDO buyer = buyerDAO.getBuyer("hmson@naver.com");

        assertThat(buyer.getBuyerName()).isEqualTo("손흥민");
        assertThat(buyer.getNickname()).isEqualTo("흥민흥민흥민");
        assertThat(buyer.getPasswd()).isEqualTo("qqqqwwww");
        assertThat(buyer.getPoint()).isEqualTo(1000000);
        assertThat(buyer.getTel()).isEqualTo(777777);
        assertThat(buyer.getBuyerImg()).isEqualTo("buyerImg-url");
        assertThat(buyer.getAddress()).isEqualTo("부산시 부산진구");

    }

    @Test
    public void deleteBuyerTest(){

        assertThat(buyerDAO.deleteBuyer("hmson@naver.com")).isEqualTo(1);
    }

}
package main.java.model.member;

import main.java.model.member.SellerDAO;
import main.java.model.member.SellerDO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SellerDAOTest {

    SellerDAO sellerDAO = new SellerDAO();



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
    public void checkSellerIdTest(){

        //중복된 아이디
        assertThat(sellerDAO.checkSellerId("longlee@daum.net")).isEqualTo(false);

        //새로운 아이디
        assertThat(sellerDAO.checkSellerId("jhj@naver.com")).isEqualTo(true);
    }

    @Test
    public void checkSellerPasswdTest(){

        //passwd 일치
        assertThat(sellerDAO.checkSellerPasswd("longlee@daum.net","1234qwer")).isEqualTo(true);

        //passwd 불일치
        assertThat(sellerDAO.checkSellerPasswd("longlee@daum.net","12341234")).isEqualTo(false);

    }

    @Test
    public void deleteSellerTest(){

        assertThat(sellerDAO.deleteSeller("longlee@daum.net")).isEqualTo(1);
    }
}
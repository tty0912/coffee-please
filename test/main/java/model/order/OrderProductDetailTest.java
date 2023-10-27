package main.java.model.order;

import org.junit.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class OrderProductDetailTest {

    OrderProductDetailDAO orderProductDetailDAO = new OrderProductDetailDAO();

    @Test
    public void insertOrderProductDetailTest() throws SQLException{
        OrderProductDetailDO order = new OrderProductDetailDO();

        order.setBuyerEmail("hmson@naver.com");
        order.setBeansNum(1);
        order.setQty(3);

        assertThat(orderProductDetailDAO.insertOrderProductDetail(order)).isEqualTo(1);
    }
}

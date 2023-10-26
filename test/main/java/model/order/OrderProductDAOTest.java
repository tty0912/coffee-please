package main.java.model.order;


import org.junit.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
public class OrderProductDAOTest {

    OrderProductDAO orderProductDAO = new OrderProductDAO();
    @Test
    public void testInsertOrderProduct() throws SQLException {
        OrderProductDO order = new OrderProductDO();

        order.setBuyerEmail("hmson@naver.com");
        order.setOrderTotalPrice(100000);
        order.setBeforeOrderPoint(1000000);
        assertThat(orderProductDAO.insertOrderProduct(order)).isEqualTo(1);
    }
}
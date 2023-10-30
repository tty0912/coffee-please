package main.java.model.order;


import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
public class OrderProductDAOTest {

    OrderProductDAO orderProductDAO = new OrderProductDAO();
    @Test
    public void testInsertOrderProduct() throws SQLException {
        OrderProductDO order = new OrderProductDO();

        order.setBuyerEmail("hmson@naver.com");
        order.setOrderTotalPrice(200000);
        order.setBeforeOrderPoint(2000000);
        assertThat(orderProductDAO.insertOrderProduct(order)).isEqualTo(1);
    }

    @Test
    public void getBuyerOrderListTest() throws SQLException{

        ArrayList<OrderProductDO> buyerOrderList = orderProductDAO.getBuyerOrderList("hmson@naver.com");
        long[] strings = new long[6];
        int i = 0;

        for(OrderProductDO s : buyerOrderList){
            strings[i] = s.getBeforeOrderPoint();
            i += 1;
        }

        assertThat(strings).isEqualTo(new long[]{1000000, 1000000, 1000000, 3000000, 2000000,2000000});
    }
}
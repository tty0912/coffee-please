package main.java.model.order;

import main.java.model.service.OrderService;
import org.junit.Test;

import java.sql.SQLException;
import static org.assertj.core.api.Assertions.*;

public class OrderTest {

    OrderService orderService = new OrderService();

    @Test
    public void onlyOnePaymentTest() throws SQLException {
        boolean result = orderService.onlyOnePayment(1, 3, "hmson@naver.com");
        assertThat(result).isEqualTo(true);
    }

}

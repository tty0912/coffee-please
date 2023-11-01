//package main.java.model.product;
package model.product;

//import main.java.model.order.OrderProductDetailDO;
import model.order.OrderProductDetailDO;

public class OrderBeans {
    private BeansDO beansDO;

    public BeansDO getBeansDO() {
        return beansDO;
    }

    public void setBeansDO(BeansDO beansDO) {
        this.beansDO = beansDO;
    }

    public OrderProductDetailDO getOrderProductDetailDO() {
        return orderProductDetailDO;
    }

    public void setOrderProductDetailDO(OrderProductDetailDO orderProductDetailDO) {
        this.orderProductDetailDO = orderProductDetailDO;
    }

    private OrderProductDetailDO orderProductDetailDO;

}

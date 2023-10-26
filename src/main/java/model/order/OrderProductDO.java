package main.java.model.order;

public class OrderProductDO {

    private String buyerEmail;
    private String orderDatetime;
    private long orderTotalPrice;
    private long beforeOrderPoint;

    public long getOrderTatalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTatalPrice(long orderTatalPrice) {
        this.orderTotalPrice = orderTatalPrice;
    }

    public long getBeforeOrderPoint() {
        return beforeOrderPoint;
    }

    public void setBeforeOrderPoint(long beforeOrderPoint) {
        this.beforeOrderPoint = beforeOrderPoint;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}

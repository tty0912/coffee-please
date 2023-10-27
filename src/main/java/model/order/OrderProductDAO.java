package main.java.model.order;
//package model.order;

import java.sql.*;
import java.util.ArrayList;

public class OrderProductDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public OrderProductDAO(){

        String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
        String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";

        try {
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url,"scott","tiger");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // 나의 주문 등록
    public int insertOrderProduct(OrderProductDO orderProduct) throws SQLException {

        int rowCount = 0;
        this.sql = "insert into order_prod (buyer_email, order_total_price, before_order_point) values( ?, ?, ?)";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderProduct.getBuyerEmail());
            pstmt.setLong(2, orderProduct.getOrderTotalPrice());
            pstmt.setLong(3, orderProduct.getBeforeOrderPoint());

            rowCount = pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(!pstmt.isClosed()) {
                    pstmt.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return rowCount;
    }

    //나의 주문내역 확인
    public ArrayList<OrderProductDO> getOrderList(String buyerEmail){

        ArrayList<OrderProductDO> orderList = new ArrayList<OrderProductDO>();
        this.sql = "select order_total_price, before_order_price from "

        return null;
    }
}

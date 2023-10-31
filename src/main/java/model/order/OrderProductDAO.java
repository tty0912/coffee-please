package model.order;
//package model.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    //나의 주문내역 목록 요청
    public ArrayList<OrderProductDO> getBuyerOrderList(String email){

        ArrayList<OrderProductDO> buyerOrderList = new ArrayList<OrderProductDO>();
        this.sql = "select order_total_price, before_order_point,to_char(order_datetime, 'YYYY-MM-DD HH24:MI:SS') as regdate" +
                " from order_prod where buyer_email = ? order by order_datetime";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            OrderProductDO order = null;

            while (rs.next()) {
                order = new OrderProductDO();
                order.setBuyerEmail(email);
                order.setOrderDatetime(rs.getString("regdate"));
                order.setOrderTotalPrice(rs.getLong("order_total_price"));
                order.setBeforeOrderPoint(rs.getLong("before_order_point"));

                buyerOrderList.add(order);
            }
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

            return buyerOrderList;
    }
}

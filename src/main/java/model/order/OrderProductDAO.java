package main.java.model.order;

import java.sql.*;

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

}

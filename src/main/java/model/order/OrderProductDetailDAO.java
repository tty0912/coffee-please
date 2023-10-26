//package main.java.model.order;
package model.order;

import java.sql.*;

public class OrderProductDetailDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    OrderProductDetailDAO(){
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

    //주문상품상세 등록
    public int insertOrderProductDetail(OrderProductDetailDO orderProductDetail){

        int rowCount = 0;
        this.sql = "insert into order_prod_detail (buyer_email, beans_num, qty) values (?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderProductDetail.getBuyerEmail());
            pstmt.setLong(2, orderProductDetail.getBeansNum());
            pstmt.setLong(3, orderProductDetail.getQty());

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

package main.java.model.order;
//package model.order;

import java.sql.*;
import java.util.ArrayList;

public class OrderProductDetailDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public OrderProductDetailDAO(){
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
    public int insertOrderProductDetail(OrderProductDetailDO orderProductDetail) throws SQLException{

        int rowCount = 0;
        this.sql = "insert into order_prod_detail (buyer_email, beans_num, qty) values (?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderProductDetail.getBuyerEmail());
            pstmt.setInt(2, orderProductDetail.getBeansNum());
            pstmt.setInt(3, orderProductDetail.getQty());

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

    //나의 주문에 해당하는 상품 전체 조회
    public ArrayList<OrderProductDetailDO> getOrderProductList(String email, String sysdate){

        ArrayList<OrderProductDetailDO> buyerOrderProductList = new ArrayList<>();
        this.sql = "select beans_num, qty " +
                "from order_prod_detail " +
                "where to_char(order_datetime, 'yyyy-mm-dd hh24:mi:ss' = ? " +
                "and buyer_email = ?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sysdate);
            pstmt.setString(2, email);
            rs = pstmt.executeQuery();

            OrderProductDetailDO orderProduct = null;

            while (rs.next()){
                orderProduct = new OrderProductDetailDO();
                orderProduct.setQty(rs.getInt("qty"));
                orderProduct.setBeansNum(rs.getInt("beans_num"));

                buyerOrderProductList.add(orderProduct);
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


        return buyerOrderProductList;
    }
}

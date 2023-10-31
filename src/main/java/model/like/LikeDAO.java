package main.java.model.like;

import java.sql.*;

public class LikeDAO {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public LikeDAO(){

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

    //Like 테이블 확인
    public boolean checkLike(String email, int beanNum) throws SQLException {

        this.sql = "select buyer_email from bean_like where buyer_email = ? and " +
                "beans_num = ?";

        try{
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.setInt(2,beanNum);
        this.rs = pstmt.executeQuery();

        }catch(Exception e) {
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
        return !rs.next();
    }

    //Like 테이블 등록
    public int insertLike(String email, int beanNum) {
        int rowCount = 0;
        try {
            this.sql = "insert into bean_like (buyer_email, beans_num) value (? , ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, beanNum);

            rowCount = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.conn.setAutoCommit(true);

                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowCount;
    }

    //Like 테이블 삭제
    public int deleteLike(String email, int beanNum){
        int rowCount = 0;
        this.sql = "delete from bean_like where buyer_email = ? and" +
                "beans_num = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, beanNum);
            rowCount = pstmt.executeUpdate();
        }
        catch (Exception e){
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

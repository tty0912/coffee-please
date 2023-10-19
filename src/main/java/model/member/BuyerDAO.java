package src.main.java.model.member;

import java.sql.*;

public class BuyerDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public BuyerDAO(){
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

    //구매자 회원 가입
    public int insertBuyer(BuyerDO buyer) throws Exception{

        int rowCount = 0;
        boolean isIdDuplicate = false;

        try{
            this.conn.setAutoCommit(false);

            this.sql = "select buyer_email from seller where buyer_email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, buyer.getBuyerEmail());
            this.rs = pstmt.executeQuery();

            if(!rs.next()){
                this.sql = "insert into seller (buyer_email, buyer_name, nickname, passwd, point, tel, adr) values (?, ?, ?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, buyer.getBuyerEmail());
                pstmt.setString(2, buyer.getBuyerName());
                pstmt.setString(3, buyer.getNickname());
                pstmt.setString(4, buyer.getPasswd());
                pstmt.setInt(5, buyer.getPoint());
                pstmt.setInt(6, buyer.getTel());
                pstmt.setString(7, buyer.getAddress());

                rowCount = pstmt.executeUpdate();
                this.conn.commit();
            }
            else{
                isIdDuplicate = true;
                this.conn.rollback();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                this.conn.setAutoCommit(true);

                if(!pstmt.isClosed()) {
                    pstmt.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(isIdDuplicate){
            throw new Exception("아이디가 중복되었습니다");
        }

        return rowCount;
    }

    //구매자 회원 정보 수정 - 구매자명, 주소, 폰번호, 이미지

    //구매자 회원 정보 삭제
    public int deleteBuyer(String email){
        int rowCount = 0;
        this.sql = "delete from buyer where buyer_email = ?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
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

    //구매자 회원 정보 요청
    public BuyerDO getBuyer(String email){

        BuyerDO buyer = null;
        this.sql = "select buyer_email, buyer_name, nickname, passwd, point, tel, to_char(regdate, 'YYYY-MM-DD HH24:MI:SS') as regdate," +
                "buyer_img, adr from buyer where buyer_email = ?";

        try{
            this.pstmt = conn.prepareStatement(sql);
            this.pstmt.setString(1, email);
            rs = this.pstmt.executeQuery();

            if(rs.next()){
                buyer.setBuyerEmail(this.rs.getString("buyer_email"));
                buyer.setBuyerName(this.rs.getString("buyer_name"));
                buyer.setNickname(this.rs.getString("nickname"));
                buyer.setPasswd(this.rs.getString("passwd"));
                buyer.setPoint(this.rs.getInt("point"));
                buyer.setTel(this.rs.getInt("tel"));
                buyer.setRegdate(this.rs.getString("regdate"));
                buyer.setBuyerImg(this.rs.getString("buyer_img"));
                buyer.setAddress(this.rs.getString("adr"));
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

        return buyer;
    }

    //conn 종료
    public void closeConn(){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

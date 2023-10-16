package main.java.model.member;

import java.sql.*;

public class MemberDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public MemberDAO(){
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

    // 특정 member 조회
    public MemberDO getMember(String id){
        return new MemberDO();
    }

    // member 등록
    public int insertMember(MemberDO member){
        return 0;
    }

    // member 정보 수정
    public int changeMember(MemberDO member){
        return 0;
    }

    // member 삭제
    public int deleteMember(int id){
        return 0;
    }

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

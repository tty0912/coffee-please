package model.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BeansDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;

	public BeansDAO() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "scott", "tiger");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상품 '정보' 조회
	public BeansDO getBean(int beansNum) {

		BeansDO beans = new BeansDO();

		sql = "select bean_name, bean_price, bean_img, descript, delivery_charge, bean_thumbnail " + 
			  "from beans where beans_num = ?";

		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setInt(1, beansNum);
			rs = this.pstmt.executeQuery();

			if (rs.next()) {
				beans.setBeanName(rs.getString("bean_name"));
				beans.setBeanPrice(rs.getInt("bean_price"));
				beans.setBeanImg(rs.getString("bean_img"));
				beans.setDescript(rs.getString("descript"));
				beans.setDeliveryCharge(rs.getInt("delivery_charge"));
				beans.setBeanThumbnail(rs.getString("bean_thumbnail"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beans;
	}
	
	// 상품 '검색' 및 페이징 처리
	public ArrayList<BeansDO> searchBeans(String beanName, int page) {
		ArrayList<BeansDO> searchResult = new ArrayList<BeansDO>();

		sql = "select beans_num, bean_name, bean_price, bean_thumbnail, beans_regdate " + 
				"from (select beans_num, bean_name, bean_price, bean_thumbnail, beans_regdate, rownum as rnum " + 
				"from beans " + 
				"where length(bean_name) >= 2 and bean_name like ?) " + 
				"where rnum between ? and ? " + 
				"ORDER BY beans_regdate desc";

		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setString(1, "%" + beanName + "%");
			// 0페이지 1 - 15 / 1페이지 15 - 30 ...
			this.pstmt.setInt(2, (page * 15) + 1);
			this.pstmt.setInt(3, (page + 1) * 15);
			rs = this.pstmt.executeQuery();

			while (rs.next()) {
				BeansDO beans = new BeansDO();

				beans.setBeansNum(rs.getInt("beans_num"));
				beans.setBeanName(rs.getString("bean_name"));
				beans.setBeanPrice(rs.getInt("bean_price"));
				beans.setBeanThumbnail(rs.getString("bean_thumbnail"));

				searchResult.add(beans);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return searchResult;
	}
	// 검색 후 마지막 페이지 처리
	public int getLastPage(String beanName) {
		int result = 0;
		
		sql = "select count(beans_num) as count from beans where bean_name like ?";
		
		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setString(1, "%" + beanName + "%");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt("count");
				
				result = count / 15;
				if(count % 15 != 0) {
					result++;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 공동구매 상품 조회 (추가 수정 필요)
	public BeansDO getGroupBean(int beansNum) {
		BeansDO beans = new BeansDO();
		
		sql = "select bean_name, bean_price, bean_img, descript, delivery_charge, bean_thumbnail, deadline, goal_qty, goal_price "
			+ "from beans where deadline is not null and beans_num = ?";

		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setInt(1, beansNum);
			rs = this.pstmt.executeQuery();

			if (rs.next()) {
				beans.setBeanName(rs.getString("bean_name"));
				beans.setBeanPrice(rs.getInt("bean_price"));
				beans.setBeanImg(rs.getString("bean_img"));
				beans.setDescript(rs.getString("descript"));
				beans.setDeliveryCharge(rs.getInt("delivery_charge"));
				beans.setBeanThumbnail(rs.getString("bean_thumbnail"));
				beans.setDeadline(rs.getString("deadline"));
				beans.setGoalQty(rs.getInt("goal_qty"));
				beans.setGoalPrice(rs.getInt("goal_price"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beans;
	}
	
	// 베스트 원두 5개
	public ArrayList<BeansDO> bestBeanArray() {
		ArrayList<BeansDO> bestBeans = new ArrayList<BeansDO>();
		
		sql = "select beans_num, bean_name, bean_price, bean_thumbnail, like_count from " +
			  "(select beans_num, bean_name, bean_price, bean_thumbnail, like_count, rownum as rnum from beans)" + 
			  "where rnum between ? and ? " +
			  "order by like_count desc"; 
		
		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setInt(1, 1);
			this.pstmt.setInt(2, 5);
			rs = this.pstmt.executeQuery();
			
			while (rs.next()) {
				BeansDO beans = new BeansDO();
				
				beans.setBeanName(rs.getString("bean_name"));
				beans.setBeanPrice(rs.getInt("bean_price"));
				beans.setBeanThumbnail(rs.getString("bean_thumbnail"));
				beans.setLikeCount(rs.getInt("like_count"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bestBeans;
	}
	

}
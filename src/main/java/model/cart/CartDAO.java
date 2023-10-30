package model.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.member.BuyerDO;
import model.product.BeansDO;

public class CartDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	public CartDAO() {
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
	
	// 장바구니 상품 추가
	// 같은 상품 추가 시 "이미 등록한 상품입니다." msg 예외 띄우기
	public int addItem (BuyerDO buyerDO, BeansDO beansDO, int qty) {
		int rowCount = 0;
		
		sql = "insert into cart (buyer_email, beans_num, qty) values (?, ?, ?)";
		
		try {
				this.pstmt = conn.prepareStatement(this.sql);
				this.pstmt.setString(1, buyerDO.getBuyerEmail());
				this.pstmt.setInt(2, beansDO.getBeansNum());
				this.pstmt.setInt(3, qty);
				
				rowCount = this.pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				this.conn.setAutoCommit(true);
				
				if (!this.pstmt.isClosed()) {
					this.pstmt.close();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rowCount;		
	}
	
	// 장바구니 상품 삭제
	public int deleteItem(BuyerDO buyerDO, BeansDO beansDO) {
		int rowCount = 0;
		
		this.sql = "delete from cart where buyer_email = ? and beans_num = ?";
		
		try {
				this.pstmt = conn.prepareStatement(this.sql);
				this.pstmt.setString(1, buyerDO.getBuyerEmail());
				this.pstmt.setInt(2, beansDO.getBeansNum());
				
				rowCount = this.pstmt.executeUpdate();				
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
		return rowCount;
	}
	
	// 장바구니 모든 상품 조회
	public ArrayList<CartDO> getCartList(String buyerEmail) {
		ArrayList<CartDO> cartList = new ArrayList<CartDO>();
		
		this.sql = "select beans.bean_name, beans.bean_price, beans.bean_img, cart.qty "+
	   			"from cart " + 
	   			"join buyer on cart.buyer_email = buyer.buyer_email " +
	   			"join beans on cart.beans_num = beans.beans_num " +
	   			"where cart.buyer_email = ?";
		
		try {
			this.pstmt = conn.prepareStatement(this.sql);
			this.pstmt.setString(1, buyerEmail);
			rs = this.pstmt.executeQuery();
			
			while(rs.next()) {
				CartDO cart = new CartDO();
				BeansDO beansDO = new BeansDO();
				
				beansDO.setBeanName(rs.getString("bean_name"));
	            beansDO.setBeanPrice(rs.getInt("bean_price"));
	            beansDO.setBeanImg(rs.getString("bean_img"));
	            
	            cart.setBeansDO(beansDO);
	            cart.setQty(rs.getInt("qty"));

				cartList.add(cart);
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
		
		return cartList;
	}
	
	// 장바구니 상품 총 금액
	public int totalPrice(String buyerEmail) {
		ArrayList<CartDO> cartList = getCartList(buyerEmail);
		
		int total = 0;
		
		 for (CartDO cart : cartList) {
		        BeansDO beansDO = cart.getBeansDO();
		        int qty = cart.getQty();
		        double price = beansDO.getBeanPrice();

		        total += price * qty;
		    }
		return total;
	}
	
	// 결제 후 장바구니 비우기 (결제 완료에서 메서드 호출)
	public int clearCart(String buyerEmail) {
	    int rowCount = 0;

	    this.sql = "delete from cart where buyer_email = ?";

	    try {
	        this.pstmt = conn.prepareStatement(this.sql);
	        this.pstmt.setString(1, buyerEmail);

	        rowCount = this.pstmt.executeUpdate();
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
	    return rowCount;
	}
}
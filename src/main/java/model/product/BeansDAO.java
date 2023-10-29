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
    
    public BeansDAO(){

    	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "scott", "tiger");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    //상품 상세보기
    public BeansDO getBeansDO(int beanNum) {
    	BeansDO bean = null;
    	this.sql = "select bean_img, bean_name, delivery_charge, bean_price, like_count, descript from beans where beans_num = ?";
    	try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, beanNum);
			rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				bean = new BeansDO();
				
				bean.setBeanImg(this.rs.getString("bean_img"));
				bean.setBeanName(this.rs.getString("bean_name"));
				bean.setDeliveryCharge(this.rs.getInt("delivery_charge"));
				bean.setBeanPrice(this.rs.getInt("bean_price"));
				bean.setLikeCount(this.rs.getInt("like_count"));
				bean.setDescript(this.rs.getString("descript"));
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
    	return bean;
    }
   
    //상품 목록 페이지 내용
    public ArrayList<BeansDO> getAllBeans()  {
    	ArrayList<BeansDO> beanList = new ArrayList<BeansDO>();
    	this.sql = "select category_num, bean_img, like_count from beans order by beans_regdate desc";
    	try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			BeansDO beansDO = null;
			
			while(rs.next()) {
				beansDO = new BeansDO();
				
				beansDO.setCategoryNum(rs.getInt("category_num"));
				beansDO.setBeanImg(rs.getString("bean_img"));
				beansDO.setLikeCount(rs.getInt("like_count"));
				
				beanList.add(beansDO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
    	return beanList;
    }
	
    //일반 판매 상품 등록하기
    //beans_num : 자동
    //판매자 이메일, 카테고리 번호, 원두 이름, 원두 가격, 원두 이미지, 원두 상세설명(이미지), 배송비, 원두 썸네일
	public int insertBean(BeansDO beansDO) {
		int rowCount = 0;
		try {
			this.conn.setAutoCommit(false);
				
			if(!rs.next()) {
				this.sql = "INSERT INTO BEANS (BEANS_NUM, SELLER_EMAIL, CATEGORY_NUM, BEAN_NAME, BEAN_PRICE, BEAN_IMG, DESCRIPT, DELIVERY_CHARGE, BEAN_THUMNAIL)"
						+ "VALUES ((select nvl(max(beans_num), 0) + 1 from beans), ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1, beansDO.getSellerEmail());
				pstmt.setInt(2, beansDO.getCategoryNum());
				pstmt.setString(3, beansDO.getBeanName());
				pstmt.setInt(4, beansDO.getBeanPrice());
				pstmt.setString(5, beansDO.getBeanImg());
				pstmt.setString(6, beansDO.getDescript());
				pstmt.setInt(7, beansDO.getDeliveryCharge());
				pstmt.setString(8, beansDO.getBeanThumbnail());
					
				rowCount = pstmt.executeUpdate();
				this.conn.commit();
			}
			else {
				this.conn.rollback();
			}
			
		}
		catch(Exception e) {
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
		
		return rowCount;
	}
	
	//공동 구매 상품 등록하기
	
	public int insertGroupBean (BeansDO beansDO) {
		int rowCount = 0;
		try {
			this.conn.setAutoCommit(false);
				
			if(!rs.next()) {
				this.sql = "insert into beans (beans_num, seller_email, bean_name, bean_price, goal_price, category_num, goal_qty, deadline, delivery_charge, bean_thumnail, descript, bean_img)"
						 + "values ((select nvl(max(beans_num), 0) + 1 from beans), ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1, beansDO.getSellerEmail());
				pstmt.setString(2, beansDO.getBeanName());
				pstmt.setInt(3, beansDO.getBeanPrice());
				pstmt.setInt(4, beansDO.getGoalPrice());
				pstmt.setInt(5, beansDO.getCategoryNum());
				pstmt.setInt(6, beansDO.getGoalQty());
				pstmt.setString(7, beansDO.getDeadline());
				pstmt.setInt(8, beansDO.getDeliveryCharge());
				pstmt.setString(9, beansDO.getBeanThumbnail());
				pstmt.setString(10, beansDO.getDescript());
				pstmt.setString(11, beansDO.getBeanImg());
					
				rowCount = pstmt.executeUpdate();
				this.conn.commit();
			}
			else {
				this.conn.rollback();
			}
			
		}
		catch(Exception e) {
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
		
		return rowCount;
	}
	
	//등록한 물품을 판매종료 로 만들기 -> status를 바꾸기, 1이면 판매종료
	public int beansSoldout(BeansDO beansDO) {
		int rowCount = 0;
		
		this.sql = "update beans set status = 1 where beans_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beansDO.getBeansNum());
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
	
	//일반 상품 판매 정보 수정 - 컨트롤러 에서 해결하면 될듯함
	/*
	public int modifyBeans(BeansDO beansDO) {
		int rowCount = 0;
		
		this.sql = "select bean_name, bean_price, delivery_charge, bean_img, descript, bean_thumbnail from beans where beans_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beansDO.getBeansNum());
			rowCount += pstmt.executeUpdate(); 
			
		this.sql = "update beans set bean_name = ?, bean_price = ?, delivery_charge =?, bean_img = ?, descript = ?, bean_thumbnail = ? where beans_num = ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, beansDO.getBeanName());
			pstmt.setInt(2, beansDO.getBeanPrice());
			pstmt.setInt(3, beansDO.getDeliveryCharge());
			pstmt.setString(4, beansDO.getBeanImg());
			pstmt.setString(5, beansDO.getDescript());
			pstmt.setString(6, beansDO.getBeanThumbnail());
			pstmt.setInt(7, beansDO.getBeansNum());
			rowCount += pstmt.executeUpdate(); 
			
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
	*/
	
	//상품 정보 수정하기
	public int modifyBeans(BeansDO beansDO) {
		int rowCount = 0;
		this.sql = "update beans set bean_name = ?, bean_price = ?, "
				+ "delivery_charge =?, bean_img = ?, descript = ?, bean_thumbnail = ? where beans_num = ?";
		try {
 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, beansDO.getBeanName());
			pstmt.setInt(2, beansDO.getBeanPrice());
			pstmt.setInt(3, beansDO.getDeliveryCharge());
			pstmt.setString(4, beansDO.getBeanImg());
			pstmt.setString(5, beansDO.getDescript());
			pstmt.setString(6, beansDO.getBeanThumbnail());
			pstmt.setInt(7, beansDO.getBeansNum());
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
	//카테고리 번호목록(국기 리스트)가져오기 - 카테고리 컬럼에 이미지로 대체할듯
	public ArrayList<CategoryDO> getAllCategory()  {
    	ArrayList<CategoryDO> categoryList = new ArrayList<CategoryDO>();
    	this.sql = "select c_name from category";
    	try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			CategoryDO category = null;
			
			while(rs.next()) {
				category = new CategoryDO();
				
				category.setCategoryName(rs.getString("c_name"));

				
				categoryList.add(category);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
    	return categoryList;
    }
	
	//원두 정렬하기 - 원산지별
	
	public ArrayList<BeansDO> arrayOrigin(String cName){
		ArrayList<BeansDO> beanList = new ArrayList<BeansDO>();
	
	   	this.sql = "select beans.bean_name, beans.bean_img, beans.like_count  "
	   				+ "from beans join category on category.category_num = beans.category_num where c_name = ?"
	   				+ "order by beans.beans_regdate desc";
	   	try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, cName);
			rs = this.pstmt.executeQuery();
			
			while(rs.next()) {
				BeansDO bean = new BeansDO();
				bean.setBeanName(rs.getString("bean_name"));
				bean.setBeanImg(rs.getString("bean_img"));
				bean.setLikeCount(rs.getInt("like_count"));
				
				beanList.add(bean);
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
    	return beanList;
	}
	
	//좋아요 많은 순 정렬
	public ArrayList<BeansDO> arrayLikeCount()  {
    	ArrayList<BeansDO> beanList = new ArrayList<BeansDO>();
    	this.sql = "select bean_name, bean_img, like_count from beans order by like_count desc";
    	try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			BeansDO beansDO = null;
			
			while(rs.next()) {
				beansDO = new BeansDO();
				
				beansDO.setBeanName(rs.getString("bean_name"));
				beansDO.setBeanImg(rs.getString("bean_img"));
				beansDO.setLikeCount(rs.getInt("like_count"));
				
				beanList.add(beansDO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
    	return beanList;
    }
	public ArrayList<BeansDO> arrayRecent()  {
    	ArrayList<BeansDO> beanList = new ArrayList<BeansDO>();
    	this.sql = "select bean_name, bean_img, like_count from beans order by beans_regdate desc";
    	try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			BeansDO beansDO = null;
			
			while(rs.next()) {
				beansDO = new BeansDO();
				
				beansDO.setBeanName(rs.getString("bean_name"));
				beansDO.setBeanImg(rs.getString("bean_img"));
				beansDO.setLikeCount(rs.getInt("like_count"));
				
				beanList.add(beansDO);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {			
			try {
				if(!stmt.isClosed()) {
					stmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
    	return beanList;
    }
	//선택 물품 장바구니에 넣기
	public int insertCart(CartDO cartDO) {
		int rowCount = 0;
		try {
			this.conn.setAutoCommit(false);
				
			if(!rs.next()) {
				this.sql = "INSERT INTO cart (BEANS_NUM, BUYER_EMAIL, qty)"
						+ "VALUES (?, ? ,?)";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1, cartDO.getBuyerEmail());
				pstmt.setInt(2, cartDO.getBeansNum());
				pstmt.setInt(3, cartDO.getQty());
					
				rowCount = pstmt.executeUpdate();
				this.conn.commit();
			}
			else {
				this.conn.rollback();
			}
			
		}
		catch(Exception e) {
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
		
		return rowCount;
	}
	
	//장바구니 속 상품을 장바구니에서 삭제하기
	public int deleteCart(int beans_num) {
		int rowCount = 0;
		CartDO cart = new CartDO();
		try {
			this.conn.setAutoCommit(false);
				
			if(!rs.next()) {
				this.sql = "delete from cart where cart.beans_num = ?";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setInt(1, cart.getBeansNum());
				rowCount = pstmt.executeUpdate();
				this.conn.commit();
			}
			else {
				this.conn.rollback();
			}
			
		}
		catch(Exception e) {
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
		
		return rowCount;
	}
	
	//장바구니 보이기
	public ArrayList<CartDO> getCartList(String buyerEmail){
		ArrayList<CartDO> cartList = new ArrayList<CartDO>();
	
	   	this.sql = "select beans.bean_name, beans.bean_price, beans.bean_img, cart.qty "+
	   			"from cart " + 
	   			"join buyer on cart.buyer_email = buyer.buyer_email " +
	   			"join beans on cart.beans_num = beans.beans_num " +
	   			"where cart.buyer_email = ?";
	   	try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, buyerEmail);
			rs = this.pstmt.executeQuery();
			
			while(rs.next()) {
				CartDO cart = new CartDO();
				cart.setBeanName(rs.getString("bean_name"));
				cart.setBeanPrice(rs.getInt("bean_price"));
				cart.setBeanImg(rs.getString("bean_img"));
				cart.setQty(rs.getInt("qty"));
				
				cartList.add(cart);
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
    	return cartList;
	}
	
	
}
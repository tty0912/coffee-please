//package main.java.controller;
package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


//import main.java.model.member.*;
import model.member.*;

@Controller
//@RequestMapping()
public class MemberController {
	private BuyerDO buyer;

	private BuyerDAO buyerDAO = new BuyerDAO();
	private SellerDO seller;
	private SellerDAO sellerDAO = new SellerDAO();

	
	public MemberController() {}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	// 구매자 회원가입페이지로 이동
	@PostMapping("/goSignupBuyer")
	public String goBuyerSignup(String id, String passwd) {
		
		return "signupBuyer";
	}
	// 판매자 회원가입페이지로 이동
	@PostMapping("/goSignupSeller")
	public String goSellerSignup(String id, String passwd) {
		
		return "signupSeller";
	}
	
	// 회원가입후 redirect
	@PostMapping("/signupBuyer")
	public String signupBuyer(@ModelAttribute BuyerDO buyer) throws Exception {
		buyer.setPoint(10000000);
	    buyerDAO.insertBuyer(buyer);
	    
	    return "redirect:/signup";
	}
	
	// 회원가입후 redirect
	@PostMapping("/signupSeller")
	public String signupSeller(@ModelAttribute SellerDO seller) throws Exception {
	    sellerDAO.insertSeller(seller);
	    
	    return "redirect:/signup";
	}
	
	// 구매자 수정 페이지로 이동
	@GetMapping("/buyerModify")
	public String goBuyerModify(String id) {
		
		return "buyerModify";
	}

	// 판매자 수정 페이지로 이동
	@GetMapping("/sellerModify")
	public String goSellerModify(String id) {
		
		return "sellerModify";
	}
	/*	
	
//	// 구매자 정보수정
//	@GetMapping("/views/buyerModify")
//	public String buyerModify(String id, Model model) {
//		
//		return "buyerModify";
//	}
	
//	// 판매자 정보수정
//	@GetMapping("/views/sellerModify")
//	public String sellerModify(String id, Model model) {
//		
//		return "sellerModify";
//	}

	
	// 판매자 로그인 
	@GetMapping("/")
	public String sellerLogin() {
		
		return "login";
	}
	
	// 구매자 로그인
	@GetMapping("/")
	public String buyerLogin() {
		
		return "login";
	}
	*/
}
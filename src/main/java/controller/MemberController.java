package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.member.BuyerDO;
import model.member.SellerDO;

@Controller
public class MemberController {
	private BuyerDO buyer;
	private SellerDO seller;
	
	public MemberController() {}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	//http://localhost:8080/coffee/main	
	
//	// 구매자 정보수정
//	@GetMapping("/views/buyerModify")
//	public String buyerModify(String id, Model model) {
//		
//		return "buyerModify";
//	}
	
	// 구매자 수정 페이지로 이동
	@GetMapping("/buyerModify")
	public String goBuyerModify(String id) {
		
		return "buyerModify";
	}
	
//	// 판매자 정보수정
//	@GetMapping("/views/sellerModify")
//	public String sellerModify(String id, Model model) {
//		
//		return "sellerModify";
//	}

	// 판매자 수정 페이지로 이동
	@GetMapping("/sellerModify")
	public String goSellerModify(String id) {
		
		return "sellerModify";
	}
	
	// 구매자 회원가입
	@GetMapping("/signupBuyer")
	public String buyerSignup(String id, String passwd) {
		
		return "signupBuyer";
	}
	
	// 판매자 회원가입
	@GetMapping("/signupSeller")
	public String sellerSignup(String id, String passwd) {
		
		return "signupSeller";
	}
	
	
	/*
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
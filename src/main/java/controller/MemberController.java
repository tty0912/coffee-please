package controller;
//package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String goBuyerSignup() {
		
		return "signupBuyer";
	}
	// 판매자 회원가입페이지로 이동
	@PostMapping("/goSignupSeller")
	public String goSellerSignup() {
		
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
	
	@PostMapping("/checkIdDuplicate")
	@ResponseBody
	public String checkIdDuplicate(@RequestParam String id) {
	    BuyerDAO buyerDAO = new BuyerDAO();
	    boolean isIdDuplicate = buyerDAO.checkBuyerId(id);
	    return isIdDuplicate ? "duplicate" : "unique";
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
	
//	// 구매자 정보수정후 redirect
//	@GetMapping("/views/buyerModify")
//	public String buyerModify(@ModelAttribute BuyerDO buyer) {
//		
//		return "redirect:/signup";
//	}




//	// 판매자 정보수정후 redirect

//	@GetMapping("/views/sellerModify")
//	public String sellerModify(@ModelAttribute SellerDO seller) {
//		
//		return "redirect:/signup";
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
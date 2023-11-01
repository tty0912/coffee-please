//package main.java.controller;
package controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	public String sessionBuyer = "";
	
	public MemberController() {}
	
	
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@PostMapping("/mainLogin")
	public String mainLogin(String id, String passwd, HttpSession session, String command, Model model) {
		
		BuyerDO buyer = buyerDAO.getBuyer(id);
		
		
		if(command.equals("login")) {
			if(buyerDAO.checkBuyerId(id) == true) {
				return "redirect:/main";
			}
			else { //id는 맞음
				if(!buyer.getPasswd().equals(passwd)) { //비밀번호는 틀림
					 return "redirect:/main";
				}else { //비밀번호도 맞음
					model.addAttribute("Buyer", buyerDAO.getBuyer(id));
					session.setAttribute("BUYER", buyer);
					
					sessionBuyer = String.valueOf(session.getAttribute("BUYER"));
					
					System.out.printf(sessionBuyer);
					
					return "mainLoginBuyer";
				}
			}
		} else if (command.equals("signup")){
			
			return "signup";
		}
		else {
			return "redirect:/main";
		}
		
	}
	
	@PostMapping("/mainLoginBuyer")
	public String logout(HttpSession session, String command, Model model) {
		
		if(command.equals("logout")) {
			session.invalidate();
			return "redirect:/main";
		} else if(command.equals("myPageBuyer")) {
			session.getAttribute("BUYER");
			System.out.printf(String.valueOf(session.getAttribute("BUYER")));
//			model.addAttribute("Buyer", buyerDAO.getBuyer());
			
			return "myPageBuyer";
		}
		
		
		return "redirect:/main";
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
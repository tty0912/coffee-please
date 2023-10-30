//package main.java.controller;
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.member.SellerDO;
import model.product.BeansDAO;
import model.product.BeansDO;
import model.product.SearchList;

@Controller
public class ProductController {
	
	private BeansDO beans;
	private BeansDAO beansDAO = new BeansDAO();
	private SearchList searchList;
	
	public ProductController() {
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	//구매자 로그인 - 메인 페이지로 이동, 세션에서 받아오기 하고, css일부 수정, 베스트 상품 게시 숫자는 쿼리나 자바스크립트??
	@GetMapping("/buyerMain")
	public String buyerMain(Model model) {
		
		model.addAttribute("categoryList", beansDAO.getAllCategory());
		model.addAttribute("bestBean", beansDAO.arrayLikeCount());
		return "MainLoginBuyer";
	}
	
	
	//판매자 로그인 - 메인페이지, 세션에서 계정 정보 가져오기, 연결되는 페이지 설정하기//
	@GetMapping("/sellerMain")
	public String sellerMain(Model model) {
		model.addAttribute("categoryList", beansDAO.getAllCategory());
		model.addAttribute("bestBean", beansDAO.arrayLikeCount());
		
		return "MainLoginSeller";
	}
	
	// 상품 목록 페이지로 이동
	@GetMapping("/beansList")
	public String beansList() {
		return "beansList";
	}
	
	// 상품 상세 페이지로 이동
	@GetMapping("/beanDetail")
	public String beanDetail(@RequestParam("beansNum") int beansNum, Model model) {
		beans = beansDAO.getBean(beansNum);
		
		if(beans != null) {
			model.addAttribute("beans", beans);
			return "beanDetail";
		}
		else {
			return "redirect:/beansList";
		}
	}
	
	// 공동 상품 상세 페이지로 이동
	@GetMapping("/groupBeanDetail")
	public String groupBeanDetail(@RequestParam("beansNum") int beansNum, Model model) {
		beans = beansDAO.getBean(beansNum);
		
		if(beans != null) {
			model.addAttribute("beans", beans);
			return "groupBeanDetail";
		}
		else {
			return "redirect:/groupBeansList";
		}
	}

	//상품 등록 후 상품 목록 페이지로 이동
	@PostMapping("/insertBeans")
	public String insertBeans(@ModelAttribute BeansDO command, Model model) {
		String viewName = "";
		try {
			beansDAO.insertBean(command);
			viewName = "redirect:/beansList";
		}
		catch(Exception e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("beansList", beansDAO.getAllBeans());
			
			viewName = "memberList";
		}
		return viewName;
	}
	//공동 상품 등록 후 상품 목록 페이지로 이동
		
	@PostMapping("/insertGroupBeans")
	public String insertGroupBeans(@ModelAttribute BeansDO command, Model model) {
		String viewName = "";
		
		try {
			beansDAO.insertGroupBean(command);
			viewName = "redirect:/beansList";
		}
		catch(Exception e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("beansList", beansDAO.getAllBeans());
			
			viewName = "memberList";
		}
		return viewName;
	}
	/*
	//판매자 마이페이지 이동 - 판매중 게시물 이동 미완성
	@PostMapping("/sellerMyPage/sellingBean")
	public String SellingBean(@ModelAttribute SellerDO command, Model model) {
		
	}
	*/
	// 상품 정보 수정 하기, 수정한 후 마이페이지로 돌아오기 - 미완성
	@PostMapping("/modifyBeans")
	public String modifyBeans(@RequestParam("beansNum") int beansNum, Model model) {
		String viewName;
		try {
			model.addAttribute("beans", beansDAO.getBeansDO(beansNum));
			viewName = "redirect:/판매자 마이페이지";
		}
		catch(Exception e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("판매자 마이페이지", beansDAO.getAllBeans());
			
			viewName = "memberList";
		}
		
		return viewName;
	}
	
}


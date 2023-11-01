package main.java.controller;
//package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import model.member.SellerDO;
import model.product.BeansDAO;
import model.product.BeansDO;

@Controller
public class ProductController {
	
	private BeansDO beans;
	private BeansDAO beansDAO = new BeansDAO();
	
	public ProductController() {
	}
	
	//비회원 접속 페이지 - 사이트 처음 들어갔을때 보이는 페이지
	@GetMapping("/mainFirst")
	public String mainFrist(Model model) {
		model.addAttribute("categoryList", beansDAO.getAllCategory());
		model.addAttribute("bestBean", beansDAO.bestBeanArray());
		return "MainNonLogin";
	}
	//구매자 로그인 - 메인 페이지로 이동, 세션에서 받아오기 하고, css일부 수정, 베스트 상품 게시 숫자는 쿼리나 자바스크립트??
	@GetMapping("/buyerMain")
	public String buyerMain(Model model) {
		
		model.addAttribute("categoryList", beansDAO.getAllCategory());
		model.addAttribute("bestBean", beansDAO.bestBeanArray());
		return "MainLoginBuyer";
	}
	
	
	//판매자 로그인 - 메인페이지, 세션에서 계정 정보 가져오기, 연결되는 페이지 설정하기//
	@GetMapping("/sellerMain")
	public String sellerMain(Model model) {
		model.addAttribute("categoryList", beansDAO.getAllCategory());
		model.addAttribute("bestBean", beansDAO.bestBeanArray());
		
		return "MainLoginSeller";
//	상품 등록
	@PostMapping("/goRegisterProduct")
	public String goRegisterProduct() {
		
		return "registerProduct";
	}
	
	@PostMapping("/registerProduct")
	public String registerProduct(@ModelAttribute BeansDO beansDO) throws Exception {
			BeansDAO beansDAO = new BeansDAO();
			beansDAO.insertBean(beansDO);		
			return "redirect:/signup";
	}
	
	// 상품 목록 페이지로 이동
	@GetMapping("/beansList")
	public String beansList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
	int totalRows = beansDAO.getTotalRows();
	int totalPages = (int) Math.ceil((double) totalRows / pageSize);
	
	// 페이지 범위를 벗어나는 페이지 번호를 조정
	if (page < 1) {
	page = 1;
	} else if (page > totalPages) {
	page = totalPages;
	}
	
	ArrayList<BeansDO> beansList = beansDAO.getBeansList(page, pageSize);
	
	model.addAttribute("beansList", beansList);
	model.addAttribute("totalPages", totalPages);
	model.addAttribute("currentPage", page);
	
	return "beansList";
	}
		
	//이전 페이지
	@GetMapping("/previousPage")
	public String previousPage(@RequestParam("currentPage") int currentPage) {
	    if (currentPage > 1) {
	        // 현재 페이지가 1보다 크다면 이전 페이지로 이동
	        return "redirect:/beansList?page=" + (currentPage - 1);
	    }
	    // 현재 페이지가 1인 경우, 동일 페이지로 유지
	    return "redirect:/beansList?page=" + currentPage;
	}
	
	// 다음 페이지
	@GetMapping("/nextPage")
	public String nextPage(@RequestParam("currentPage") int currentPage, 
	                       @RequestParam("totalPages") int totalPages) {
	    if (currentPage < totalPages) {
	        // 현재 페이지가 총 페이지 수보다 작다면 다음 페이지로 이동
	        return "redirect:/beansList?page=" + (currentPage + 1);
	    }
	    // 현재 페이지가 마지막 페이지인 경우, 동일 페이지로 유지
	    return "redirect:/beansList?page=" + currentPage;
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


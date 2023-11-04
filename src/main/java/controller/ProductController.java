//package main.java.controller;
package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.product.BeansDAO;
import model.product.BeansDO;
import model.member.*;

@Controller
public class ProductController {
	
	private BeansDO beans;
	private BeansDAO beansDAO = new BeansDAO();
	private SellerDAO sellerDAO = new SellerDAO();
	
	public ProductController() {
	}
	

	
//	상품 등록
	@GetMapping("/goRegisterProduct")
	public String goRegisterProduct() {
		
		return "registerProduct";
	}
	
	@PostMapping("/registerProduct")
	public String registerProduct(@ModelAttribute BeansDO beansDO, HttpSession session, Model model) throws Exception {
		
		String sessionSeller = String.valueOf(session.getAttribute("sellerEmail"));
		model.addAttribute("seller", sellerDAO.getSeller(sessionSeller));
		
		BeansDAO beansDAO = new BeansDAO();
		beansDAO.insertBean(beansDO, session);	
		return "redirect:/signup";
	}

	// 상품 목록 페이지
	@GetMapping("/beansList")
	public String beansList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
	            @RequestParam(value = "sort", required = false, defaultValue = "default") String sort,
	            @RequestParam(value = "search", required = false) String search) {
		// 상품 목록을 가져오는 기본 메서드
        ArrayList<BeansDO> beansList;

        // 정렬 필요한 경우 sortedPage 메서드 호출
        beansList = beansDAO.sortedPage(sort, search);
        
        // 페이징 처리를 위한 전체 상품 수 계산
        int totalRows = beansList.size();
        int totalPages = (int) Math.ceil((double) totalRows / pageSize);

        // 페이지 범위를 조정
        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }

        // 페이징 처리를 위해 부분 리스트 선택
        int startRow = 1 + (page - 1) * pageSize;
        int endRow = pageSize * page;
        ArrayList<BeansDO> pagedBeansList = new ArrayList<>(beansList.subList(
        	    Math.max(startRow - 1, 0), Math.min(endRow, totalRows))); 

        // 모델에 데이터 추가
        model.addAttribute("sortOption", sort);
        model.addAttribute("beansList", pagedBeansList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);

        return "beansList";
	}
	
	// 공동 구매 상품 목록 페이지
	@GetMapping("/groupBeansList")
	public String groupBeansList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
	            @RequestParam(value = "sort", required = false, defaultValue = "default") String sort, 
	            @RequestParam(value = "search", required = false) String search) {
	    
	    ArrayList<BeansDO> groupBeansList;
	    
        groupBeansList = beansDAO.sortedPage2(sort, search);
	    
	    int totalRows = groupBeansList.size();
	    int totalPages = (int) Math.ceil((double) totalRows / pageSize);

	    if (page < 1) {
	        page = 1;
	    } else if (page > totalPages) {
	        page = totalPages;
	    }

	    int startRow = 1 + (page - 1) * pageSize;
	    int endRow = pageSize * page;
	    ArrayList<BeansDO> pagedGroupBeansList = new ArrayList<>(groupBeansList.subList(
	            Math.max(startRow - 1, 0), Math.min(endRow, totalRows))); 

	    model.addAttribute("sortOption", sort);
	    model.addAttribute("groupBeansList", pagedGroupBeansList);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("search", search);

	    return "groupBeansList";
	}
	
	// 이전, 다음 페이지 처리
	@GetMapping("/navigatePage")
	public String navigatePage(@RequestParam("currentPage") int currentPage, 
	                            @RequestParam("totalPages") int totalPages,
	                            @RequestParam("direction") String direction, 
	                            @RequestParam("search") String search,
	                            @RequestParam("redirectPath") String redirectPath) {
	    if ("previous".equals(direction) && currentPage > 1) {
	        return "redirect:" + redirectPath + "?page=" + (currentPage - 1) + "&search=" + search;
	    } else if ("next".equals(direction) && currentPage < totalPages) {
	        return "redirect:" + redirectPath + "?page=" + (currentPage + 1) + "&search=" + search;
	    }
	    return "redirect:" + redirectPath + "?page=" + currentPage + "&search=" + search;
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

//	//상품 등록 후 상품 목록 페이지로 이동
//	@PostMapping("/insertBeans")
//	public String insertBeans(@ModelAttribute BeansDO command, Model model) {
//		String viewName = "";
//		try {
//			beansDAO.insertBean(command);
//			viewName = "redirect:/beansList";
//		}
//		catch(Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			model.addAttribute("beansList", beansDAO.getAllBeans());
//			
//			viewName = "memberList";
//		}
//		return viewName;
//	}
//	//공동 상품 등록 후 상품 목록 페이지로 이동
//		
//	@PostMapping("/insertGroupBeans")
//	public String insertGroupBeans(@ModelAttribute BeansDO command, Model model) {
//		String viewName = "";
//		
//		try {
//			beansDAO.insertGroupBean(command);
//			viewName = "redirect:/beansList";
//		}
//		catch(Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			model.addAttribute("beansList", beansDAO.getAllBeans());
//			
//			viewName = "memberList";
//		}
//		return viewName;
//	}
//	/*
//	//판매자 마이페이지 이동 - 판매중 게시물 이동 미완성
//	@PostMapping("/sellerMyPage/sellingBean")
//	public String SellingBean(@ModelAttribute SellerDO command, Model model) {
//		
//	}
//	*/
//	// 상품 정보 수정 하기, 수정한 후 마이페이지로 돌아오기 - 미완성
//	@PostMapping("/modifyBeans")
//	public String modifyBeans(@RequestParam("beansNum") int beansNum, Model model) {
//		String viewName;
//		try {
//			model.addAttribute("beans", beansDAO.getBeansDO(beansNum));
//			viewName = "redirect:/판매자 마이페이지";
//		}
//		catch(Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			model.addAttribute("판매자 마이페이지", beansDAO.getAllBeans());
//			
//			viewName = "memberList";
//		}
//		
//		return viewName;
//	}
	
}


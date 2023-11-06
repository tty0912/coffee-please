//package main.java.controller;
package controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.product.BeansDAO;
import model.product.BeansDO;

@Controller
public class ProductController {
	
	private BeansDO beans;
	private BeansDAO beansDAO = new BeansDAO();
	
	public ProductController() {
	}
	
	public ProductController(BeansDAO beansDAO) {
		this.beansDAO = beansDAO;
	}
	
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
	
	// 상품 목록 페이지
//		@GetMapping("/productList")
//		public String productList(Model model, 
//		            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
//		            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
//		            @RequestParam(value = "category", required = false, defaultValue = "0") int categoryNum,
//		            @RequestParam(value = "sort", required = false, defaultValue = "recent") String sort,
//		            @RequestParam(value = "search", required = false) String search) {
//			// 상품 목록을 가져오는 기본 메서드
//	        ArrayList<BeansDO> beansList;
//	        
//	        // 카테고리 번호 0 일 경우 모든 상품 불러오기, 카테고리 선택 시 해당 카테고리에 맞는 상품 정보 제공
//	        if(categoryNum == 0) {
//	        	beansList = beansDAO.getAllBeans(search);
//	        }
//	        else {
//	        	beansList = beansDAO.sortedPage(sort, search, categoryNum); 	
//	        }
//	       
//	              
//	        // 페이징 처리를 위한 전체 상품 수 계산
//	        int totalRows = beansList.size();
//	        int totalPages = (int) Math.ceil((double) totalRows / pageSize);
//
//	        // 페이지 범위를 조정
//	        if (page < 1) {
//	            page = 1;
//	        } else if (page > totalPages) {
//	            page = totalPages;
//	        }
//
//	        // 페이징 처리를 위해 부분 리스트 선택
//	        int startRow = 1 + (page - 1) * pageSize;
//	        int endRow = pageSize * page;
//	        ArrayList<BeansDO> pagedBeansList = new ArrayList<>(beansList.subList(
//	        	    Math.max(startRow - 1, 0), Math.min(endRow, totalRows))); 
//
//	        // 모델에 데이터 추가
//	        model.addAttribute("categoryNum", categoryNum);
//	        model.addAttribute("sortOption", sort);
//	        model.addAttribute("beansList", pagedBeansList);
//	        model.addAttribute("totalPages", totalPages);
//	        model.addAttribute("currentPage", page);
//	        model.addAttribute("search", search);
//
//	        return "productList";
//		}

		// 상품 목록 페이지
		@GetMapping("/beansList")
		public String beansList(Model model, 
		            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
		            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
		            @RequestParam(value = "category", required = false, defaultValue = "0") int categoryNum,
		            @RequestParam(value = "sort", required = false, defaultValue = "recent") String sort,
		            @RequestParam(value = "search", required = false) String search) {
		// 상품 목록을 가져오는 기본 메서드
        ArrayList<BeansDO> beansList;
        
        // 카테고리 번호 0 일 경우 모든 상품 불러오기, 카테고리 선택 시 해당 카테고리에 맞는 상품 정보 제공
        if(categoryNum == 0) {
        	beansList = beansDAO.getAllBeans(search);
        }
        else {
        	beansList = beansDAO.sortedPage(sort, search, categoryNum);     	
        }
                     
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
        model.addAttribute("categoryNum", categoryNum);
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
	            @RequestParam(value = "category", required = false, defaultValue = "0") int categoryNum,
	            @RequestParam(value = "sort", required = false, defaultValue = "recent") String sort, 
	            @RequestParam(value = "search", required = false) String search) {
	    
	    ArrayList<BeansDO> groupBeansList;
	    
	    if(categoryNum == 0) {
	    	groupBeansList = beansDAO.getAllGroupBeans(search);
        }
        else {
        	groupBeansList = beansDAO.sortedPage2(sort, search, categoryNum);     	
        }
	    
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
	
//	@GetMapping("/navigatePage")
//	public String navigatePage(@RequestParam("currentPage") int currentPage, 
//	                            @RequestParam("totalPages") int totalPages,
//	                            @RequestParam("direction") String direction, 
//	                            @RequestParam("categoryNum") int categoryNum, 
//	                            @RequestParam("search") String search,
//	                            @RequestParam("sort") String sort) {
//	    
//	    String url = "?search=" + search + "&sort=" + sort + "&category=" + categoryNum;	   
//	    if (!"recent".equals(sort)) {
//	        return "?page=" + currentPage + url;
//	    }
//	    if ("previous".equals(direction) && currentPage > 1) {
//	        return "?page=" + (currentPage - 1) + url;
//	    } else if ("next".equals(direction) && currentPage < totalPages) {
//	        return "?page=" + (currentPage + 1) + url;
//	    }
//	    return "?page=" + currentPage + "&search=" + search + "&sort=" + sort + "&category=" + categoryNum;
//	}

	
	// 이전, 다음 페이지 처리
	@GetMapping("/navigatePage")
	public String navigatePage(@RequestParam("currentPage") int currentPage, 
	                            @RequestParam("totalPages") int totalPages,
	                            @RequestParam("direction") String direction, 
	                            @RequestParam("category") int categoryNum, 
	                            @RequestParam("search") String search,
	                            @RequestParam("sort") String sort) {
		
		
		String category = "&category=" + categoryNum;
		
		if (!"recent".equals(sort)) {
	        return "?page=" + currentPage + 
	        		"&search=" + search + 
	        		"&sort=" + sort + category;
	    }
		
	    if ("previous".equals(direction) && currentPage > 1) {
	        return "?page=" + (currentPage - 1) + 
	        		"&search=" + search + 
	        		"&sort=" + sort + category;
	    } else if ("next".equals(direction) && currentPage < totalPages) {
	        return "?page=" + (currentPage + 1) + 
	        		"&search=" + search + 
	        		"&sort=" + sort + category;
	    }
	    return "?page=" + currentPage + "&search=" + search + category;
	}
	
	// 상품 상세 페이지로 이동
		@GetMapping("/productListDetail")
		public String productListDetail(@RequestParam("beansNum") int beansNum, Model model) {
			beans = beansDAO.getBean(beansNum);
			
			if(beans != null) {
				model.addAttribute("productListDetail", beansDAO.getBean(beansNum));
				return "productListDetail";
			}
			else {
				return "redirect:/productListDetail";
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
	
//	// 상품 목록 페이지 테스트
//	@GetMapping("/beansList")
//	public String beansList(Model model, 
//	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
//	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
//	            @RequestParam(value = "category", required = false, defaultValue = "0") int categoryNum,
//	            @RequestParam(value = "sortCol", required = false, defaultValue = "beans_num") String sort,
//	            @RequestParam(value = "desc", required = false) boolean desc,
//	            @RequestParam(value = "search", required = false) String search) {
//		// 상품 목록을 가져오는 기본 메서드
//        ArrayList<BeansDO> beansList;
//        
//        // 카테고리 번호 0 일 경우 모든 상품 불러오기, 카테고리 선택 시 해당 카테고리에 맞는 상품 정보 제공
//        beansList = beansDAO.getBeansList(categoryNum, search, sort, desc);
//                     
//        // 페이징 처리를 위한 전체 상품 수 계산
//        int totalRows = beansList.size();
//        int totalPages = (int) Math.ceil((double) totalRows / pageSize);
//
//        // 페이지 범위를 조정
//        if (page < 1) {
//            page = 1;
//        } else if (page > totalPages) {
//            page = totalPages;
//        }
//
//        // 페이징 처리를 위해 부분 리스트 선택
//        int startRow = 1 + (page - 1) * pageSize;
//        int endRow = pageSize * page;
//        ArrayList<BeansDO> pagedBeansList = new ArrayList<>(beansList.subList(
//        	    Math.max(startRow - 1, 0), Math.min(endRow, totalRows))); 
//
//        // 모델에 데이터 추가
//        model.addAttribute("categoryNum", categoryNum);
//        model.addAttribute("sortOption", sort);
//        model.addAttribute("beansList", pagedBeansList);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("search", search);
//
//        return "beansList";
//	}
	
}


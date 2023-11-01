package controller;
//package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.product.BeansDAO;
import model.product.BeansDO;

@Controller
public class ProductController {
	
	private BeansDO beans;
	private BeansDAO beansDAO = new BeansDAO();
	
	public ProductController() {
	}
	
//	테스트 컨트롤러
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
	@GetMapping("/beansList")
	public String beansList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
	            @RequestParam(value = "sort", required = false, defaultValue = "default") String sort) {
		// 상품 목록을 가져오는 기본 메서드
        ArrayList<BeansDO> beansList;

        // 정렬 필요한 경우 sortedPage 메서드 호출
        beansList = beansDAO.sortedPage(sort);
        
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

        return "beansList";
	}
	
	// 공동 구매 상품 목록 페이지
	@GetMapping("/groupBeansList")
	public String groupBeansList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
	            @RequestParam(value = "sort", required = false, defaultValue = "default") String sort) {
	    
	    ArrayList<BeansDO> groupBeansList;

	    if (sort != null || !sort.equals("default")) {
	        groupBeansList = beansDAO.sortedPage2(sort);
	    } 
	    else {
	        groupBeansList = beansDAO.getGroupBeansList();
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

	    model.addAttribute("groupBeansList", pagedGroupBeansList);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);

	    return "groupBeansList";
	}
	
	// 검색 결과 목록 페이지
	@GetMapping("/searchList")
	public String searchList(Model model, 
	            @RequestParam(value = "page", required = false, defaultValue = "1") int page, 
	            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize,
	            @RequestParam(value = "sort", required = false, defaultValue = "default") String sort) {
	    
	    ArrayList<BeansDO> searchList;

	    if (sort != null || !sort.equals("default")) {
	    	searchList = beansDAO.sortedPage(sort);
	    } 
	    else {
	    	searchList = beansDAO.getBeansList();
	    }
	    
	    int totalRows = searchList.size();
	    int totalPages = (int) Math.ceil((double) totalRows / pageSize);

	    if (page < 1) {
	        page = 1;
	    } else if (page > totalPages) {
	        page = totalPages;
	    }

	    int startRow = 1 + (page - 1) * pageSize;
	    int endRow = pageSize * page;
	    ArrayList<BeansDO> pagedSearchList = new ArrayList<>(searchList.subList(
	            Math.max(startRow - 1, 0), Math.min(endRow, totalRows))); 

	    model.addAttribute("searchList", pagedSearchList);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);

	    return "searchList";
	}
	
	// 이전, 다음 페이지 처리
	@GetMapping("/navigatePage")
	public String navigatePage(@RequestParam("currentPage") int currentPage, 
	                            @RequestParam("totalPages") int totalPages,
	                            @RequestParam("direction") String direction,
	                            @RequestParam("redirectPath") String redirectPath) {
	    if ("previous".equals(direction) && currentPage > 1) {
	        return "redirect:" + redirectPath + "?page=" + (currentPage - 1);
	    } else if ("next".equals(direction) && currentPage < totalPages) {
	        return "redirect:" + redirectPath + "?page=" + (currentPage + 1);
	    }
	    return "redirect:" + redirectPath + "?page=" + currentPage;
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
}

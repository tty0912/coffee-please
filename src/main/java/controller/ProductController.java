package controller;
//package controller;

import java.util.ArrayList;

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
			
	@GetMapping("/main")
	public String main() {
		return "main";
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
}

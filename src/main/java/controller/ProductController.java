//package main.java.controller;
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.member.BuyerDO;
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
	
//	테스트 컨트롤러
	@PostMapping("/goRegisterProduct")
	public String goRegisterProduct() {
		
		return "registerProduct";
	}
	
	@PostMapping("/registerProduct")
	public String signupBuyer(@ModelAttribute BeansDO beans) throws Exception {
		
		BeansDAO.insertBeans(beans);
	    
	    return "redirect:/signup";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
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
}

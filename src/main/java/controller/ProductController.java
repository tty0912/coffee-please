//package main.java.controller;
package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.product.BeansDAO;
import model.product.BeansDO;
import model.member.SellerDAO;
import model.product.*;


/*
 * 	1) GET	|	/
 */


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

	
	
	//상품등록
	@GetMapping("/registerProductPage")
	public String resisterProduct(HttpSession session, Model model) {
		
		String sessionSeller = String.valueOf(session.getAttribute("sellerEmail"));
		model.addAttribute("seller", sellerDAO.getSeller(sessionSeller));
	
		return "registerProduct";
	}
	@GetMapping("/registerProductGroup")
	public String resisterProductGroup(HttpSession session, Model model) {
		
		String sessionSeller = String.valueOf(session.getAttribute("sellerEmail"));
		model.addAttribute("seller", sellerDAO.getSeller(sessionSeller));
	
		return "registerProductGroup";
	}
	
	@PostMapping("/registerProduct")
	public String resisterProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
        String directory = "C:\\\\Users\\Jun\\Desktop\\finalproject\\coffee-please\\src\\main\\webapp\\uploadTest";
        
        int sizeLimit = 1024 * 1024 * 5;
        MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit,
                "UTF-8", new DefaultFileRenamePolicy());
    	
    	String action = multi.getParameter("action");
        if (action != null && action.equals("register")) {
            // 파일 업로드 액션
            System.out.println(directory);
            // 디렉토리 생성w
            File uploadDir = new File(directory);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String savedName = "";
            String savedName1 = "";
            @SuppressWarnings("unchecked")
            Enumeration<String> fileNames = multi.getFileNames();
            if (fileNames.hasMoreElements()) {
                String paramName = fileNames.nextElement();
                savedName = multi.getFilesystemName(paramName);
            }
            if (fileNames.hasMoreElements()) {
            	String paramName = fileNames.nextElement();
            	savedName1 = multi.getFilesystemName(paramName);
            }
            // 파일 정보를 photo 변수에 저장
            String beanImg = "\\finalProject\\uploadTest" + savedName; // 웹 경로로 수정
            String descript = "\\finalProject\\uploadTest" + savedName1; // 웹 경로로 수정
            String sellerEmail = "longlee@daum.net";
            String beanName = multi.getParameter("beanName");
            int beanPrice = Integer.parseInt(multi.getParameter("beanPrice"));
            int categoryNum = 1;
            int deliveryCharge = Integer.parseInt(multi.getParameter("deliveryCharge"));

            // 게시물 생성
            BeansDO newBeans = new BeansDO();
            newBeans.setBeanImg(beanImg);
            newBeans.setDescript(descript);
            newBeans.setSellerEmail(sellerEmail);
            newBeans.setBeanName(beanName);
            newBeans.setBeanPrice(beanPrice);
            newBeans.setCategoryNum(categoryNum);
            newBeans.setDeliveryCharge(deliveryCharge);
            // id 설정 - 필요한 경우 수정
//            newBeans.setId((String)request.getSession().getAttribute("userId"));
            // 데이터베이스에 새 게시물 추가
            beansDAO.insertBeans(newBeans);
//            request.setAttribute("uploadedPhoto", photo);
        }
        // 업로드 후 다시 갤러리 페이지로 리다이렉트 또는 원하는 페이지로 이동
//        response.sendRedirect("BoardController");
        return "main";
    }
   }















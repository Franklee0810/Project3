package controller.admin;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Ad;
import bean.Admin;
import dao.AdminDao;

  
@Controller
public class AdminController {
	private ModelAndView mav  ;
	
	@Autowired
	@Qualifier("admindao")
	private AdminDao adao;
  
	public AdminController() {	
		this.mav = new ModelAndView();
	}
	@GetMapping("login.admin")
	public ModelAndView doGet() {
		System.out.println(getClass() + "doGet"); 
		
		this.mav.setViewName("/login"); 
	  
		return this.mav;
	}
	
	@PostMapping("adminpage.admin") 
	public ModelAndView Login(
			@RequestParam(value="id") String id,
			@RequestParam(value="password") String password,
			HttpSession session) {
        	System.out.println(getClass() + " Login");

			//아이디 비밀번호 매개변수로 관리자 가져와서 admin에 넣음 
			Admin admin = this.adao.selectAdmin(id, password);
			if(admin != null) {
				
				List<Ad> lists = adao.getAdList();
				
				 
				//관리자 세션 바인딩
				session.setAttribute("admin", admin);
				this.mav.addObject("lists", lists);
				this.mav.setViewName("/adminpage");
			} else {
				this.mav.setViewName("redirect:/main.co");
			}
			return this.mav; 
	 
	}
	
}

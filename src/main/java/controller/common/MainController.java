package controller.common;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

 
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
	private ModelAndView mav;
	
  
	public MainController() {
		
		this.mav = new ModelAndView();
	}
	@GetMapping("main.co")
	public ModelAndView doGet(HttpSession session) {
		System.out.println(getClass() + "doGet"); 
		this.mav.setViewName("/main"); 
	  
		return this.mav;
	}
}

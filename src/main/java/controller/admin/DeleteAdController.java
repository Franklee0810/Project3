package controller.admin;
import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import bean.Ad;
import bean.Admin;
import dao.AdminDao;
import utility.UploadFileUtils;

  
@Controller
public class DeleteAdController {
	private ModelAndView mav  ;
	
	@Autowired
	@Qualifier("admindao")
	private AdminDao adao;
	
	//admin-config.xml에서 설정했던 uploadPath 추가..
	@Resource(name="uploadPath")
	private String uploadPath;
	
	public DeleteAdController() {	
		this.mav = new ModelAndView();
	}
	
  
	@RequestMapping(value="/delete_ad.admin", method=RequestMethod.GET) 
	public ModelAndView InsertAd(HttpServletRequest request) throws Exception{
		 
		System.out.println(getClass() + "delete_ad.admin");
		
		int no =  Integer.parseInt(request.getParameter("no"));
		
		int cnt = adao.deleteAdlistByPk(no);
		
		if(cnt == 1) {
			System.out.println("success_delete");
		} else {
			System.out.println("failed_delete");
		}
		this.mav.setViewName("/adminpage");
		System.out.println("깃깃");
		System.out.println("깃은 깃이다");
		return this.mav;
		
	} 
  	
}

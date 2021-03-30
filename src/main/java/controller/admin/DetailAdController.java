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
public class DetailAdController {
	private ModelAndView mav  ;
	
	@Autowired
	@Qualifier("admindao")
	private AdminDao adao;
	
	//admin-config.xml에서 설정했던 uploadPath 추가..
	@Resource(name="uploadPath")
	private String uploadPath;
	
	public DetailAdController() {	
		this.mav = new ModelAndView();
	}
	
  
	@RequestMapping(value="/detailad.admin", method=RequestMethod.GET) 
	public ModelAndView InsertAd(HttpServletRequest request) throws Exception{
		System.out.println(getClass() + "detailad.admin 도착");

		int no = Integer.parseInt(request.getParameter("no"));
		
		Ad ad = adao.getAdListByPk(no); 
		mav.addObject("ad", ad);
		
		this.mav.setViewName("/ad_detail"); 
		return this.mav;
		
	} 
  	
}

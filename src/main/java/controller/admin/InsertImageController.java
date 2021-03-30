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
public class InsertImageController {
	private ModelAndView mav  ;
	
	@Autowired
	@Qualifier("admindao")
	private AdminDao adao;
	
	//admin-config.xml에서 설정했던 uploadPath 추가..
	@Resource(name="uploadPath")
	private String uploadPath;
	
	public InsertImageController() {	
		this.mav = new ModelAndView();
	}
	
	
	@GetMapping("createfile.admin")
	public ModelAndView createfile() {
		System.out.println(getClass() + "createfile"); 
		this.mav.setViewName("/createfile");
	
		return this.mav;
	}
	
	@RequestMapping(value="insert_image.admin", method=RequestMethod.POST) 
	public String InsertAd(Ad ad, MultipartFile file, HttpSession session, HttpServletRequest request, MultipartHttpServletRequest mhsrequest) throws Exception{
		System.out.println(getClass() + "insert_image.admin 도착");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename()  , file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		ad.setImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		ad.setThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		ad.setTitle(request.getParameter("title"));
		ad.setAd_type(request.getParameter("ad_type"));
		
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("ad_type"));
		
		adao.InsertAd(ad);
		return "/adminpage";
	}
		
		
//		List<MultipartFile> fileList = mhsrequest.getFiles("file");
// 		String path = request.getRealPath("uploadFile/image/"); // 저장위치
//
//		
//		for(MultipartFile multipartFile : fileList) {
//	            System.out.println("================== file start ==================");
//	            System.out.println("파일 이름: "+multipartFile.getName());
//	            System.out.println("파일 실제 이름: "+multipartFile.getOriginalFilename());
//	            System.out.println("파일 크기: "+multipartFile.getSize());
//	            System.out.println("content type: "+multipartFile.getContentType());
//	            System.out.println("================== file   END ==================");
//	            
//	            String origin_name = multipartFile.getOriginalFilename(); // 원본 파일명 
//	            long file_size = multipartFile.getSize();
//	            
//	            
//	          //확장자 짤라줌
//	            String ext = origin_name.substring(origin_name.indexOf("."));
//	            System.out.println(ext);
//	            
//	            String safeFile = path + System.currentTimeMillis() + origin_name;
//	            System.out.println("safeFile : " + safeFile);
//	}
	             
	            
	            
	        

		
		
  	
}

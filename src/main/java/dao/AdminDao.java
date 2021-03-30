package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.Ad;
import bean.Admin;
 
@Component("admindao")
public class AdminDao {
	private final String namespace = "NsAdmin.";
	
	@Autowired
	SqlSessionTemplate sql;
	
	  public Admin selectAdmin(String id, String password) {
	        System.out.println(getClass() + " selectAdmin");
	        Map<String, String> map = new HashMap<String, String>() ;
	        map.put("id", id) ;
	        map.put("password", password) ;
	        return this.sql.selectOne(namespace + "selectAdmin", map);
	    }

	public void InsertAd(Ad ad) {
		System.out.println(getClass() + "Insert 접근");
		sql.insert(namespace+ "InsertAd", ad);
		
	}

	public List<Ad> getAdList() {
		System.out.println(getClass() + "getAdList");
		return this.sql.selectList(namespace + "getAdList");
	}

	public Ad getAdListByPk(int no) {
		System.out.println(getClass() + "getAdListByPk");
		return this.sql.selectOne(namespace + "getAdListByPk" , no);
	}

	public int deleteAdlistByPk(int no) {
		System.out.println("깃깃");
		System.out.println("깃은 깃이다");
		return this.sql.delete(namespace + "deleteListByPk", no);
		
	}
}

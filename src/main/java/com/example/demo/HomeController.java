package com.example.demo;
import java.util.*;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
 
	@Autowired  
    JdbcTemplate jdbc;
	
	@RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "home";
	}
	
	
	@RequestMapping("/add")
	public String add(){
		return "adminlogin";
	}    
	
	
	
	@RequestMapping("/edit")
	public String edit() {
		return "admin";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	
	
	@RequestMapping("/upd")
	public String upd(HttpServletRequest req, HttpServletResponse res) {
		String name=req.getParameter("name");
		String rate=req.getParameter("rate");
    	String tax=req.getParameter("tax");
    	jdbc.execute("update gst.product_details set gst =gg ,rate=new_rate where product_name='nameofpro';"
    			.replace("new_rate", rate).replace("nameofpro", name).replace("gg",tax));
		return "update";
	
	}
	
	@RequestMapping("/view")
	public String view() {
		return "success";
	}
	
	@RequestMapping("/ul")
	public String view() {
		return "userlogin";
    }
    @RequestMapping("/to")
	public String view() {
		return "tracking";
    }
    
    
    @
    @RequestMapping("/gen")
    public String generate() {
    	String sql="create table gst.bills ( Product_Code varchar(50),  Product_Name varchar(50), Rate varchar(5), "
    			+ "Tax varchar(6), Quantity varchar(5), Amount varchar(10)) ";
    	jdbc.execute(sql);
    	return "user";
    }
    
  
}

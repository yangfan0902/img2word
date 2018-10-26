package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;
import service.ItemService;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin(){
		
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String password,HttpSession session){
		
		User user=userService.findUser(name, password);
		
		if(user==null){
			return "register";
		}else{
			session.setAttribute("name", name);
			
			return "redirect:/item/itemListByName.action";
		}
		
	}
	
	@RequestMapping("toRegister")
	public String toRegister(){
		
		return "register";
	}
	
	@RequestMapping("register")
	public String register(String name,String password){
		userService.saveUser(name,password);
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

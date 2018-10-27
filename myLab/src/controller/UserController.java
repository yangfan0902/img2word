package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;
import exception.MyException;
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
	public String login(String name,String password,HttpSession session) throws MyException{
		
		User user=userService.findUser(name, password);
		
		if(user==null){
			throw new MyException("���������û���������");
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
	public String register(String name,String password,Model model) throws MyException{
		try{
			userService.saveUser(name,password);
			model.addAttribute("message", "ע��ɹ�");
			return "message";
		}catch(Exception e){
			throw new MyException("�û����ѱ�ʹ��");
		}
		
	}
	
	//ע���û�
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("name");
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

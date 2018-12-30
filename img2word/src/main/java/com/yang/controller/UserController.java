package com.yang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.bytecode.analysis.MultiArrayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yang.service.Img2word;
import com.yang.service.UserService;

import pojo.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private Img2word imgConvertService;
	
	@RequestMapping("/hello/{id}")
	public User SelectUser(@PathVariable int id){
		return userService.selectUser(id);
	}
	
	@RequestMapping("/123")
	public ModelAndView index(HttpSession session){
		session.setAttribute("name", "xiaoyang");
		ModelAndView model=new ModelAndView("comment");
		model.addObject("session", session);
		return model;
	}
	
	@RequestMapping("/img2word")
	public ModelAndView toImg2word(HttpSession session){
		ModelAndView model=new ModelAndView("img2word");
		return model;
	}
	
	@RequestMapping("/dealImg")
	@ResponseBody
	public Map img2word(@RequestParam("file")MultipartFile file,HttpServletResponse response) throws IOException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> result=new HashMap<String, String>();
		String words=null;
		if(file!=null){
			byte[] img=file.getBytes();
			words=imgConvertService.img2word(img);
			result.put("words", words);
			result.put("success", "success");
			System.out.println(words);
		}
		return result;
	}
}

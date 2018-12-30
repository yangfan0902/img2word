package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Item;
import bean.QueryVo;
import exception.MyException;
import service.ItemService;
import service.ItemServiceImpl;

@Controller
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/updateitem.action")
		public ModelAndView itemUpdate(HttpServletRequest request){
		

			Item item=this.itemService.findItemById(Integer.parseInt(request.getParameter("id")));
			item.setPrice(Double.parseDouble(request.getParameter("price")));
			item.setDescription(request.getParameter("description"));
			item.setNumber(Integer.parseInt(request.getParameter("number")));
			item.setProduct(request.getParameter("product"));
			
			itemService.updateItem(item);
			
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "修改成功");
			modelAndView.setViewName("message");
			return modelAndView;
		}
	@RequestMapping("/toItemList")
	public ModelAndView toItemList(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("itemList");
		return modelAndView;
	}

	@RequestMapping("/itemListByName")
	public String queryItemListByName(HttpSession session,Model model){
		
		String name=(String)session.getAttribute(" ");
		if(name==null){
			return "forward:/item/login.action";
		}
		if(name.equals("肖睿")){
			
			return "redirect:/item/allItemList.action";
		}
		
		List<Item> list=this.itemService.queryItemListByName((String)session.getAttribute("name"));
		model.addAttribute("itemList", list);
		
		return "forward:/item/toItemList.action";
	}
	
	@RequestMapping("/itemEdit")
	public ModelAndView editItem(HttpServletRequest request){
		String id=request.getParameter("id");
		ModelAndView modelAndView=new ModelAndView();
		if(request.getParameter("method").equals("update")){
			Item item=itemService.findItemById(Integer.parseInt(id));
			
			modelAndView.addObject("item", item);
			modelAndView.setViewName("editItem");
			return modelAndView;
		}
		else if(request.getParameter("method").equals("delete")){
			itemService.deleteById(Integer.parseInt(id));
			modelAndView.addObject("message", "删除成功");
			modelAndView.setViewName("message");
			return modelAndView;
		}
		return null;
		
	}
	@RequestMapping("/addItem.action")
	public ModelAndView addItem(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("addItem");
		return modelAndView;
	}
	
	@RequestMapping("/add.action")
	public String add(QueryVo queryVo,ArrayList<Item> itemList,HttpSession session) throws MyException{
		try{
			for(Item i:queryVo.getItemList()){
				
				i.setName((String)session.getAttribute("name"));
				i.setDate((new Date()).getTime());
				itemService.saveItem(i);
			}
			
			return "redirect:/item/itemListByName.action";
		}catch(Exception e){
			throw new MyException("订单内容不能为空");
		}
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/allItemList")
	public ModelAndView findAllItem(){
		
		List<Item> itemList=itemService.findAllItem();
		
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("allItemList", itemList);
		
		modelAndView.setViewName("allItemList");
		return modelAndView;
	}
	
	@RequestMapping("/itemListByWeek")
	public ModelAndView itemListByWeek(){
		Long currentTime=(new Date()).getTime();
		List<Integer> list=this.getTimeList();
		List<Item> itemList=itemService.findItemByWeek(currentTime,list);
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("allItemList", itemList);
		
		modelAndView.setViewName("allItemList");
		return modelAndView;
	}
	

	@RequestMapping("/itemListByNameByWeek")
	public String queryItemListByNameByWeek(HttpSession session,Model model){
		
		String name=(String)session.getAttribute("name");
		if(name==null){
			return "forward:/item/login.action";
		}
		if(name.equals("肖睿")){
			
			return "redirect:/item/allItemList.action";
		}
		long currentTime=(new Date()).getTime();
		List<Integer> list=this.getTimeList();
		List<Item> itemList=this.itemService.findItemByNameWeek(currentTime, list, name);
		model.addAttribute("itemList", itemList);
		
		return "forward:/item/toItemList.action";
	}
	
	public static List<Integer> getTimeList(){
		
		Calendar calendar=Calendar.getInstance();
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		int min=calendar.get(Calendar.MINUTE);
		int sec=calendar.get(Calendar.SECOND);
		ArrayList<Integer> list=new ArrayList<>();
		list.add(dayOfWeek);
		list.add(hour);
		list.add(min);
		list.add(sec);
		return list;
	}
	
	
	
	
	
	
	
}

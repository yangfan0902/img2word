package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Item;
import bean.QueryVo;
import service.ItemService;
import service.ItemServiceImpl;

@Controller
@RequestMapping("item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/updateitem.action")
		public ModelAndView itemUpdate(HttpServletRequest request){
		List<Item> list=this.itemService.queryItemList();

			Item item=this.itemService.findItemById(Integer.parseInt(request.getParameter("id")));
			item.setPrice(Double.parseDouble(request.getParameter("price")));
			item.setDescription(request.getParameter("description"));
			item.setNumber(Integer.parseInt(request.getParameter("number")));
			item.setProduct(request.getParameter("product"));
			
			itemService.updateItem(item);
			
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "success");
			modelAndView.setViewName("message");
			return modelAndView;
		}

	@RequestMapping("/itemListByName")
	public ModelAndView queryItemListByName(HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		String name=(String)session.getAttribute("name");
		if(name==null){
			modelAndView.setViewName("login");
			return modelAndView;
		}
		List<Item> list=this.itemService.queryItemListByName((String)session.getAttribute("name"));
		
		
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
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
			modelAndView.addObject("message", "success");
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
	public ModelAndView add(QueryVo queryVo,ArrayList<Item> itemList){
		
		for(Item i:queryVo.getItemList()){
			itemService.saveItem(i);
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("message");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	
	
	
	
	
	
}

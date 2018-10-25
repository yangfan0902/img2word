package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Item;
import service.ItemService;
import service.ItemServiceImpl;

@Controller
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

	@RequestMapping("/itemList")
	public ModelAndView queryItemList(){
		List<Item> list=this.itemService.queryItemList();
		ModelAndView modelAndView=new ModelAndView();
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
}

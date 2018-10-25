package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Item;
import dao.ItemDao;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
		
	@Override
	public List<Item> queryItemList() {
		
		List<Item> list=this.itemDao.selectAll();
		
		return list;
	}

	@Override
	public Item findItemById(int id) {
		Item item=this.itemDao.findItemById(id);
		return item;
	}

	@Override
	public void updateItem(Item item) {
		
		this.itemDao.updateItem(item);
	}

	@Override
	public void deleteById(int id) {
		this.itemDao.deleteById(id);
		
	}

	@Override
	public void saveItem(Item item) {
		this.itemDao.saveItem(item);
		
	}
	
	

}

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
	public List<Item> findAllItem() {
		
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

	@Override
	public List<Item> queryItemListByName(String name) {
		
		List<Item> list=this.itemDao.selectByName(name);
		
		return list;
	}

	@Override
	public List<Item> findItemByWeek(long currentTime,List list) {
				
		long time=this.getLastFriday(currentTime, list);
		List<Item> itemList=itemDao.findItemByWeek(time);
		return itemList;
	}

	@Override
	public List<Item> findItemByNameWeek(Long currentTime, List<Integer> list,String name) {
		long time=this.getLastFriday(currentTime, list);
		List<Item> itemList=itemDao.findItemByNameWeek(time,name);
		
		return itemList;
	}
	
	public static long getLastFriday(long currentTime,List list){
		long time;
		int day=0;
		if((Integer)list.get(0)==6){
			day=0;
		}else if((Integer)list.get(0)==7){
			day=1;
		}else if((Integer)list.get(0)==1){
			day=2;
		}else if((Integer)list.get(0)==2){
			day=3;
		}else if((Integer)list.get(0)==3){
			day=4;
		}else if((Integer)list.get(0)==4){
			day=5;
		}else if((Integer)list.get(0)==5){
			day=6;
		}
	
		time=currentTime-1000*3600*24*day-1000*3600*(Integer)list.get(1)-1000*60*(Integer)list.get(2)-1000*(Integer)list.get(3);
		return time;
	}
	
	

}

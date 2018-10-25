package dao;

import java.util.List;

import bean.Item;

public interface ItemDao {
	
	void saveItem(Item item);
	
	Item findItemById(int id);

	List<Item> selectAll();
	
	void updateItem(Item item);

	void deleteById(int id);
}

package service;

import java.util.List;

import bean.Item;

public interface ItemService {
	List<Item> queryItemList();
	Item findItemById(int id);
	void updateItem(Item item);
	void deleteById(int id);
}

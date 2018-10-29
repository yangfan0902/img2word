package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.Item;

public interface ItemDao {
	
	void saveItem(Item item);
	
	Item findItemById(int id);

	List<Item> selectAll();
	
	void updateItem(Item item);

	void deleteById(int id);

	List<Item> selectByName(String name);

	List<Item> findItemByWeek(long time);

	List<Item> findItemByNameWeek(@Param("time")long time,@Param("name")String name);
}

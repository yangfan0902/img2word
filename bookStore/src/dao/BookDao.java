package dao;

import java.util.List;

import domain.Book;
import domain.QueryResult;

public interface BookDao {

	void add(Book b);

	Book find(String id);
	List getAlBook();
	QueryResult pageQuery(int startIndex, int pageSize, String where, Object param);

}
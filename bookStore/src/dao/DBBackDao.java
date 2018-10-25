package dao;

import java.util.List;

import domain.DBBack;

public interface DBBackDao {

	void add(DBBack back);

	List getAll();

	DBBack find(String id);

}
package dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.BookDao;
import domain.Book;
import domain.Category;
import domain.QueryResult;
import utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public void add(Book b){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			String sql="insert into book (id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object params[]={b.getId(),b.getName(),b.getAuthor(),b.getPrice(),b.getImage(),b.getDescription(),b.getCategory().getId()};		
			runner.update(conn, sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#find(java.lang.String)
	 */
	@Override
	public Book find(String id){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			String sql="select * from book where id=?";		
			return (Book) runner.query(conn, sql, id, new BeanHandler(Book.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	 //where = "where category_id=?"
	private List<Book> getPageData(int startIndex,int pageSize,String where,Object param){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			if(where==null||where.trim().equals("")){
				String sql="select * from book limit ?,?";
				Object params[]={startIndex,pageSize};
				return (List<Book>) runner.query(conn, sql, params, new BeanListHandler(Book.class));
			}
			else{
				String sql="select * from book "+where+" limit ?,?";
				Object params[]={param,startIndex,pageSize};
				List<Book> list= (List<Book>) runner.query(conn, sql, params, new BeanListHandler(Book.class));
				return list;
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private int getPageTotalRecord(int startIndex,int pageSize,String where,Object param){
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			if(where==null||where.trim().equals("")){
				String sql="select count(*) from book";
				return ((Long) runner.query(conn, sql, new ScalarHandler())).intValue();
			}else{
				String sql="select count(*) from book "+where;
				return ((Long) runner.query(conn, sql,param, new ScalarHandler())).intValue();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#pageQuery(int, int, java.lang.String, java.lang.Object)
	 */
	@Override
	public QueryResult pageQuery(int startIndex,int pageSize,String where,Object param){
		List<Book> list=getPageData(startIndex,pageSize,where,param);
		int totalRecord= getPageTotalRecord(startIndex,pageSize,where,param);
		
		QueryResult qr=new QueryResult();
		qr.setList(list);
		qr.setTotalRecord(totalRecord);
		
		return qr;
	}
	
	@Override
	public List getAlBook() {
		try{
			Connection conn=JdbcUtils.getConnection();
			QueryRunner runner=new QueryRunner();
			String sql="select * from book";		
			return (List) runner.query(conn, sql, new BeanListHandler(Book.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

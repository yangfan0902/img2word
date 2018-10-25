package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.DBBackDao;
import domain.DBBack;
import utils.JdbcUtils;

public class DBBackDaoImpl implements DBBackDao {
	/* (non-Javadoc)
	 * @see dao.impl.DBBackDao#add(domain.DBBack)
	 */
	@Override
	public void add(DBBack back){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSoure_back());
			String sql="insert into dbback(id,filename,backtime,description) values(?,?,?,? )";
			Object param[]={back.getId(),back.getFilename(),back.getBacktime(),back.getDescription()};
			runner.update(sql, param);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.DBBackDao#getAll()
	 */
	@Override
	public List getAll(){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSoure_back());
			String sql="select * from dbback order by backtime desc";
			
			List backs=(List) runner.query(sql, new BeanListHandler(DBBack.class));
			return backs;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.DBBackDao#find(java.lang.String)
	 */
	@Override
	public DBBack find(String id){
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSoure_back());
			String sql="select * from dbback where id=?";
			
			return (DBBack) runner.query(sql,id,new BeanHandler(DBBack.class));
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

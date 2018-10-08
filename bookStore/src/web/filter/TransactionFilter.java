package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import utils.JdbcUtils;

public class TransactionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try{
			//���������󣬻�ȡ���ӣ��������񣬲������Ӱ󶨵���ǰ�߳�
			JdbcUtils.StartTransaction();
			
			chain.doFilter(request, response);//Ŀ����Դִ��
			
			//��ȡ��ǰ�߳��ϰ󶨵����ӣ��ύ���񣬲��ر����ӣ��ͷ������뵱ǰ�̵߳İ�
			JdbcUtils.commitTransaction();
		}finally{
			JdbcUtils.closeConn();
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}

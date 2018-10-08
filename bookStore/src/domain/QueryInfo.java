package domain;
//封装查询信息
public class QueryInfo {
	private int currentPage=1;
	private int pageSize=3;
	private int startIndex;
	private String queryName;
	private String queryValue;
	private String where;
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return this.startIndex=(this.currentPage-1)*this.pageSize;
	}
	
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQueryValue() {
		return queryValue;
	}
	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}
	public String getWhere() {
		if(this.queryName==null||this.queryName.trim().equals("")){
			return "";
		}
		else{
			this.where="where "+queryName+"=?";
		}
		return where;
	}
	
	
}

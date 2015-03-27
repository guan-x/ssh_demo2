package cn.gx.domain.view;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageBean {

	//传�?�的参数或配置的�?
	private int 	currentPage 	;  //当前�?
	private int 	pageSize		;  //每页显示多少条记�?

	//查询数据�?
	private List 	recordList		;  //本页数据列表
	private int 	recordCount		;  //总记录数
	
	//计算（由变量固定�?
	private int 	pageCount		;  //总页�?
	private int 	beginPageIndex	;  //页码列表的开始索�?
	private int 	endPageIndex	;  //页码列表的结束索�?
	
	/**
	 * 只接�?4个必要的属�?��?�，自动计算出其�?3个属性的�?
	 * @param currentPage
	 * @param pageSize
	 * @param recordList
	 * @param recordCount
	 */
	public PageBean(int currentPage, int pageSize, List recordList,
			int recordCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		
		//计算pageCount
		this.pageCount=(recordCount+pageSize-1)/pageSize;
		
		//计算beginPageIndex与endPageIndex
		//总页码小�?10
		if(pageCount<=10){
			//全部显示
			beginPageIndex=1;
			endPageIndex=pageCount;
		}
		//总页码大�?10
		else{
			//显示当前页面附近10个页码（�?4+当前+�?5�?
			beginPageIndex=currentPage-4;
			endPageIndex=currentPage+5;
			//算完后，当前页前小于4个，显示10个页�?
			if(beginPageIndex<1){
				beginPageIndex=1;
				endPageIndex=10;
			}
			//当前页后不足5个，显示�?10个页�?
			else if(endPageIndex>pageCount){
				endPageIndex=pageCount;
				beginPageIndex=pageCount-9;
			}
		}
		
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
}

package cn.gx.domain.view;

import java.util.List;


/**
 * 分页页面的模�?
 * 
 * @author always_w_u
 * 
 * page; currentPage // 当前�?
rows; pageSize// 每页显示多少条记�?
recordCount; // 总记录数
recordList; // 本页数据列表

pageCount		;  //总页�?
beginPageIndex	;  //页码列表的开始索�?
endPageIndex	;  //页码列表的结束索�?
 *
 */
public class ComplexPage extends Page{

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
	
	
	public ComplexPage(Page page) {
		this(page.getPage(), page.getRows(), page.getRecordList(), page.getRecordCount());
		//super(currentPage,pageSize,recordList,recordCount);
		int recordCount=this.getRecordCount();
		int pageSize=this.getRows();
		int currentPage=this.getPage();
		
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

	public ComplexPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ComplexPage(int page, int rows, List recordList, int recordCount) {
		super(page, rows, recordList, recordCount);
		// TODO Auto-generated constructor stub
	}

	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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

package cn.gx.domain.view;

import java.util.List;

public class Page {

	// 传�?�的参数或配置的�?
	private int page; // 当前�?
	private int rows; // 每页显示多少条记�?
	private int recordCount; // 总记录数

	// 查询数据�?
	private List recordList; // 本页数据列表

	private String sort;
	private String order;

	private boolean isAsc;
	
	public Page() {
		super();
	}

	public Page(int page, int rows, List recordList, int recordCount) {
		super();
		this.page = page;
		this.rows = rows;
		this.recordCount = recordCount;
		this.recordList = recordList;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
	
}

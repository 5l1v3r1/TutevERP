package org.tutev.web.erp.util;

import java.util.List;

public class PageingModel<T> {

	public PageingModel() {
	
	}
		
	public PageingModel(List<T> list, int record) {
		this.list = list;
		this.rowCount = record;
	}


	List<T> list;
	int rowCount;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

}

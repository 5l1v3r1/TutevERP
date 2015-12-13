package org.tutev.web.erp.util;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageingModel {

	public PageingModel() {
	
	}
		
	@SuppressWarnings("unchecked")
	public PageingModel( List list, int record) {
		this.list = list;
		this.rowCount = record;
	}


	List<Object> list;
	int rowCount;

	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

}

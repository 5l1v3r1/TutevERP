package org.tutev.web.erp.util;

import java.io.Serializable;

public class AppUtils implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166697053754891639L;
	private String wsAdress;
	
	
	public AppUtils(String wsAdress) {
		this.setWsAdress(wsAdress);
	}
	
	public String getWsAdress() {
		return wsAdress;
	}
	
	public void setWsAdress(String wsAdress) {
		this.wsAdress = wsAdress;
	}

}

package org.tutev.web.erp.util;

public class AppUtils {
	
	
	
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

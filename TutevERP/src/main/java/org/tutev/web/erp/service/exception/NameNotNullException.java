package org.tutev.web.erp.service.exception;

public class NameNotNullException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385548171857223465L;

	String message;
	

	@Override
	public String getMessage() {
		this.message="Ad Boþ Olmamalýdýr";
		return super.getMessage()+ this.message;
	}
}

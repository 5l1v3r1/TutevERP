package org.tutev.web.erp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("homeController")
@Scope("session")
public class HomeController  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1230194639120955098L;

	private String username;
	@PostConstruct
	private void init() {
//		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		username="Taner";
		
	}
	
	public String getUsername() {
		return username;
	}
}

package org.tutev.web.erp.controller;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.Kullanici;

@Controller("loginController")
@Scope("session")
public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1353518910268384731L;
	
	private Kullanici aktifKullanici;
	

	public void init() {

	}
	
	public String doLogin() {
	    try {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext extenalContext = facesContext.getExternalContext();
		    RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_check");
		    dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());
		    facesContext.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "";
	}
	
	public void doLogout() {
	    try {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext extenalContext = facesContext.getExternalContext();
		    RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_logout");
		    dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());
		    facesContext.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Kullanici getAktifKullanici() {
		if(aktifKullanici==null){
			aktifKullanici =new Kullanici();			
		}
		return aktifKullanici;
	}
	
	public void setAktifKullanici(Kullanici aktifKullanici) {
		this.aktifKullanici = aktifKullanici;
	}
}

package org.tutev.web.erp.controller.fatura;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.fatura.Fatura;
import org.tutev.web.erp.service.FaturaService;


@Controller("faturaController")
@Scope("session")
public class FaturaController implements Serializable{

	@Autowired
	private transient FaturaService  faturaService;

	private Fatura fatura;
	List<Fatura> faturaListesi;

	@PostConstruct
	public void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		faturaListesi=faturaService.getAll();
	}

	public void faturaKaydet() {
		faturaService.save(fatura);

		faturaListesi=faturaService.getAll();
		fatura=null;
	}
	
	public List<Fatura> getFaturaListesi() {
		return faturaListesi;
	}

	public Fatura getFatura() {
	 if(fatura==null)
		 fatura=new Fatura();
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		
		this.fatura = fatura;
	}

	
	
}

package org.tutev.web.erp.controller.fatura;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.fatura.Fatura;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.service.fatura.FaturaService;


@Controller("faturaController")
@Scope("session")
public class FaturaController implements Serializable{

	@Autowired
	private transient FaturaService  faturaService;

	private Fatura fatura;
	List<Fatura> faturaListesi;

	@PostConstruct
	public void init() {
		
		faturaListesi=faturaService.getAll();
	}

	public void faturaKaydet() {
		try {
			if(fatura.getId()==null)
				faturaService.save(fatura);
			else
				faturaService.update(fatura);	
			
			faturaListesi=faturaService.getAll();
		} catch (Exception e) {
		}
	}
	
	public List<Fatura> getFaturaListesi() {
		return faturaListesi;
	}
	
	
	public void sil(Long id) {
		Fatura silinecekFatura = faturaService.getById(id);
		faturaService.delete(silinecekFatura);
		faturaListesi=faturaService.getAll();
	}
	
	public void duzenle(Long id) {
		fatura = faturaService.getById(id);
	}
	
	public void yeni() {
		fatura=null;
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

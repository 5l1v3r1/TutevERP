package org.tutev.web.erp.controller.genel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.service.KisiService;
import org.tutev.web.erp.util.PageingModel;

@Controller("kisiController")
@Scope("session")
public class KisiController implements Serializable {

	/**
	 * Taner TEMEL
	 */
	private static final long serialVersionUID = -3607896108305768125L;

	@Autowired
	private transient KisiService kisiService;

	private Kisi kisi;
	
	LazyDataModel<Kisi> lazy;
 
	@PostConstruct
	public void init() {
		listele();
	}

	public void kisiKaydet() {
		try {
			if(kisi.getId()==null)
				kisiService.save(kisi);
			else
				kisiService.update(kisi);	
			
			listele();
		} catch (Exception e) {
		}

	}
	
	public void listele() {
		
		lazy=new LazyDataModel<Kisi>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1117065338221723478L;

			@Override
			public List<Kisi> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageingModel<Kisi> kisiler=kisiService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(kisiler.getRowCount());
				return kisiler.getList();
			}
		};

	}
	
	public void sil(Long id) {
		Kisi silinecekKisi = kisiService.getById(id);
		kisiService.delete(silinecekKisi);
		listele();
	}
	
	public void duzenle(Long id) {
		kisi = kisiService.getById(id);
	}
	
	public void yeni() {
		kisi=null;
	}

	public Kisi getKisi() {
		if (kisi == null) {
			kisi = new Kisi();
		}
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	
	public LazyDataModel<Kisi> getLazy() {
		return lazy;
	}
}

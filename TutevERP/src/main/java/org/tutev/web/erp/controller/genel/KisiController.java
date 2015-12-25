package org.tutev.web.erp.controller.genel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.base.Adres;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.service.KisiService;
import org.tutev.web.erp.service.KodluListeService;
import org.tutev.web.erp.util.PageingModel;

@Controller("kisiController")
@Scope("view")
public class KisiController implements Serializable {

	/**
	 * Taner TEMEL
	 */
	private static final long serialVersionUID = -3607896108305768125L;

	@Autowired
	private transient KisiService kisiService;
	@Autowired
	private transient KodluListeService kodluListeService;

	private Kisi kisi;
	private KodluListe filterUyruk;
	
	LazyDataModel<Kisi> lazy;
 
	@PostConstruct
	public void init() {
//		System.out.println("T-CONTRUCT");
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
	
	public List<KodluListe> acomp(String query) {
		return kodluListeService.acomp(query);
	}
	
	public void ajaxCall() {
		listele();
	}
	
	public void listele() {
		
		lazy=new LazyDataModel<Kisi>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1117065338221723478L;

			@SuppressWarnings("unchecked")
			@Override
			public List<Kisi> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				if(filterUyruk!=null && filterUyruk.getId()!=null ){
					filters.put("uyruk", filterUyruk);
				}
				
				PageingModel kisiler=kisiService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(kisiler.getRowCount());
				return kisiler.getList();
			}

			@Override
			public void forEach(Consumer<? super Kisi> arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Spliterator<Kisi> spliterator() {
				// TODO Auto-generated method stub
				return null;
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
		if(kisi!=null && kisi.getAdres()==null){
			kisi.setAdres(new Adres());;
		}
	}
	
	public void yeni() {
		kisi=null;
	}

	public Kisi getKisi() {
		if (kisi == null) {
			kisi = new Kisi();
			kisi.setAdres(new Adres());
		}
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	
	public LazyDataModel<Kisi> getLazy() {
		return lazy;
	}
	
	public KodluListe getFilterUyruk() {
		if(filterUyruk==null){
			filterUyruk=new KodluListe();
		}
		return filterUyruk;
	}
	
	public void setFilterUyruk(KodluListe filterUyruk) {
		this.filterUyruk = filterUyruk;
	}
}

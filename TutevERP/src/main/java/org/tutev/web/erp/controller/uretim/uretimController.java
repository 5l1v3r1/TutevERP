package org.tutev.web.erp.controller.uretim;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.uretim.Uretim;
import org.tutev.web.erp.service.UretimService;
import org.tutev.web.erp.util.PageingModel;

@Controller("uretimController")
@Scope("session")
public class uretimController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2735969159815934322L;

	/**
	 * Erhan KÖSE
	 * 
	 
	 */
	  

	@Autowired
	private transient UretimService uretimService;

	private Uretim uretim;
	
	LazyDataModel<Uretim> lazy;
 
	@PostConstruct
	public void init() {
		listele();
	}

	public void uretimKaydet() {
		try {
			if(uretim.getId()==null)
				uretimService.save(uretim);
			else
				uretimService.update(uretim);	
			
			listele();
		} catch (Exception e) {
		}

	}
	
	public void listele() {
		
		lazy=new LazyDataModel<Uretim>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3730467643008812472L;

			/**
			 * 
			 */
			//private static final long serialVersionUID = -1117065338221723478L;

			@Override
			public List<Uretim> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageingModel<Uretim> uretimler=uretimService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(uretimler.getRowCount());
				return uretimler.getList();
			}
		};

	}
	
	public void sil(Long id) {
		Uretim silinecekUretim = uretimService.getById(id);
		uretimService.delete(silinecekUretim);
		listele();
	}
	
	public void duzenle(Long id) {
		uretim = uretimService.getById(id);
	}
	
	public void yeni() {
		uretim=null;
	}

	public Uretim getUretim() {
		if (uretim == null) {
			uretim = new Uretim();
		}
		return uretim;
	}

	public void setUretim(Uretim uretim) {
		this.uretim = uretim;
	}
	
	public LazyDataModel<Uretim> getLazy() {
		return lazy;
	}
}

/**
 * 
 */
package org.tutev.web.erp.controller.stokhareket;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.stokhareket.Depo;
import org.tutev.web.erp.service.KodluListeService;
import org.tutev.web.erp.service.stokhareket.DepoService;
import org.tutev.web.erp.util.PageingModel;

@Controller("depoController")
@Scope("view")
public class DepoController implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -1827726623616477635L;

	@Autowired
	private transient DepoService depoService;
	@Autowired
	private transient KodluListeService kodluListeService;

	private Depo depo;
	private KodluListe filterDepoTuru;
	
	LazyDataModel<Depo> lazy;

	@PostConstruct
	public void init() {
		listele();
	}

	public void depoKaydet() {
		try {
			if(depo.getId()==null)
				depoService.save(depo);
			else
				depoService.update(depo);	
			
			listele();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void sil(Long id) {
		Depo silinecekDepo = depoService.getById(id);
		depoService.delete(silinecekDepo);
		listele();
	}
	
	public void duzenle(Long id) {
		depo = depoService.getById(id);
	}
	
	public void yeni() {
		depo = null;
	}

	public void listele() {
		
		lazy=new LazyDataModel<Depo>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8687445177321936423L;

			@SuppressWarnings("unchecked")
			@Override
			public List<Depo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				if(filterDepoTuru!=null && filterDepoTuru.getId()!=null ){
					filters.put("depoTuru", filterDepoTuru);
				}
				
				PageingModel depolar=depoService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(depolar.getRowCount());
				return depolar.getList();
			}

		};
	}
	/**
	 * @return the depo
	 */
	public Depo getDepo() {
		if (depo == null) {
			depo = new Depo();
		}
		return depo;
	}

	/**
	 * @param depo the depo to set
	 */
	public void setDepo(Depo depo) {
		this.depo = depo;
	}

	/**
	 * @return the lazy
	 */
	public LazyDataModel<Depo> getLazy() {
		return lazy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DepoController [lazy=" + lazy + ", depo=" + depo + "]";
	}

	public List<KodluListe> acomp(String query) {
		return kodluListeService.acomp(query);
	}
	
	public void ajaxCall() {
		listele();
	}

	/**
	 * @return the filterDepoTuru
	 */
	public KodluListe getFilterDepoTuru() {
		if (filterDepoTuru == null) {
			filterDepoTuru = new KodluListe();
		}
		return filterDepoTuru;
	}

	/**
	 * @param filterDepoTuru the filterDepoTuru to set
	 */
	public void setFilterDepoTuru(KodluListe filterDepoTuru) {
		this.filterDepoTuru = filterDepoTuru;
	}


}

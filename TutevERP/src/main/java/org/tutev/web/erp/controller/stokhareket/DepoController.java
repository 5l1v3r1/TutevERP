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

/**
 * @author gemini
 *
 */
@Controller("depoController")
@Scope("session")
public class DepoController implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -1827726623616477635L;

	@Autowired
	private transient DepoService depoService;
	@Autowired
	private transient KodluListeService kodluListeService;

	LazyDataModel<Depo> lazy;

	private Depo depo;
	List<Depo> depoListesi;
	
	@PostConstruct
	public void init() {
		listele();
	}

	public void depoKaydet() {
		// irsaliye.setTarih(new Date());
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

	public void listele() {
		lazy=new LazyDataModel<Depo>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8687445177321936423L;

			/**
			 * 
			 */
			@SuppressWarnings("unchecked")
			@Override
			public List<Depo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
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
		return depo;
	}

	/**
	 * @param depo the depo to set
	 */
	public void setDepo(Depo depo) {
		this.depo = depo;
	}

	/**
	 * @return the depoListesi
	 */
	public List<Depo> getDepoListesi() {
		return depoListesi;
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
		final int maxLen = 10;
		return "DepoController [lazy=" + lazy + ", depo=" + depo + ", depoListesi="
				+ (depoListesi != null ? depoListesi.subList(0, Math.min(depoListesi.size(), maxLen)) : null) + "]";
	}

	public List<KodluListe> acomp(String query) {
		return kodluListeService.acomp(query);
	}
	
	public void ajaxCall() {
		listele();
	}


}

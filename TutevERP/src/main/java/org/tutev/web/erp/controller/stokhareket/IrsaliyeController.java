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
import org.tutev.web.erp.entity.stokhareket.Irsaliye;
import org.tutev.web.erp.service.stokhareket.IrsaliyeService;
import org.tutev.web.erp.util.PageingModel;

/**
 * @author Mehmet Emin IŞIK
 *
 */
@Controller("irsaliyeController")
@Scope("session")
public class IrsaliyeController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5319940611320885717L;

	@Autowired
	private transient IrsaliyeService irsaliyeService;
	
	LazyDataModel<Irsaliye> lazy;

	private Irsaliye irsaliye;
	List<Irsaliye> irsaliyeListesi;

	@PostConstruct
	public void init() {
		listele();
	}

	public void irsaliyeKaydet() {
		// irsaliye.setTarih(new Date());
		try {
			if(irsaliye.getId()==null)
				irsaliyeService.save(irsaliye);
			else
				irsaliyeService.update(irsaliye);	
			
			listele();
		} catch (Exception e) {
		}
	}

	/**
	 * @return the irsaliye
	 */
	public Irsaliye getIrsaliye() {
		if (irsaliye == null) {
			irsaliye = new Irsaliye();
		}
		return irsaliye;
	}

	/**
	 * @param irsaliye
	 *            the irsaliye to set
	 */
	public void setIrsaliye(Irsaliye irsaliye) {
		this.irsaliye = irsaliye;
	}

	/**
	 * @return the irsaliyeListesi
	 */
	public List<Irsaliye> getIrsaliyeListesi() {
		return irsaliyeListesi;
	}


	public void listele() {
		lazy=new LazyDataModel<Irsaliye>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8687445177321936423L;

			/**
			 * 
			 */
			@SuppressWarnings("unchecked")
			@Override
			public List<Irsaliye> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				PageingModel irsaliyeler=irsaliyeService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(irsaliyeler.getRowCount());
				return irsaliyeler.getList();
			}
		};
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IrsaliyeController [irsaliye=" + irsaliye + ", irsaliyeListesi=" + irsaliyeListesi + "]";
	}

	/**
	 * @return the lazy
	 */
	public LazyDataModel<Irsaliye> getLazy() {
		return lazy;
	}
	
	/**
	 * 
	 */
	public void yeni() {
		irsaliye = null;
	}
	
	/**
	 * @param silinecek irsaliye id
	 */
	public void sil(Long id) {
		Irsaliye sil=irsaliyeService.getById(id);
		irsaliyeService.delete(sil);
		listele();
	}
	
	public void duzenle(Long id) {
		irsaliye = irsaliyeService.getById(id);
	}
}

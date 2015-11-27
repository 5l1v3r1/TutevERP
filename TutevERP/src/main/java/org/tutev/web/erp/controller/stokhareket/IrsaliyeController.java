/**
 * 
 */
package org.tutev.web.erp.controller.stokhareket;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.stokhareket.Irsaliye;
import org.tutev.web.erp.service.stokhareket.IrsaliyeService;

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

	private Irsaliye irsaliye;
	List<Irsaliye> irsaliyeListesi;

	@PostConstruct
	private void init() {
		irsaliyeListesi = irsaliyeService.getAll();
	}

	public void irsaliyeKaydet() {
		// irsaliye.setTarih(new Date());
		irsaliyeService.save(irsaliye);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IrsaliyeController [irsaliye=" + irsaliye + ", irsaliyeListesi=" + irsaliyeListesi + "]";
	}

}

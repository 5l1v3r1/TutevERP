package org.tutev.web.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.genel.KodluListeTip;
import org.tutev.web.erp.service.DataService;
import org.tutev.web.erp.service.KodluListeService;

@Component("dataController")
@Scope("singleton")
public class DataController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2141891297862838000L;

	@Autowired
	private transient DataService dataService;
	@Autowired
	private transient KodluListeService kodluListeService;

	public static Logger logger = Logger.getLogger(DataController.class);

	private List<KodluListe> uyrukListe;
	private List<KodluListe> olcuBirimListe;
	private List<KodluListe> paraBirimListe;

	@PostConstruct
	private void init() {
		dataGuncelle();
		if (uyrukListe == null || uyrukListe.size() < 1) {
			logger.debug("Referans Data Bulunamad� DB insert Yap�l�yor");
			kodluListeService.save(new KodluListe(null, "TC","T�rkiye Cumhuriyeti", KodluListeTip.UYRUK));
			kodluListeService.save(new KodluListe(null, "ABD","Amerika Birle�ik Devletleri", KodluListeTip.UYRUK));
			kodluListeService.save(new KodluListe(null, "FR", "Fransa",KodluListeTip.UYRUK));
			logger.debug("Referans Data Bulunamad� DB insert Yap�ld�");
			dataGuncelle();
		}
	}

	public void dataGuncelle() {
		logger.info("Referans Data Y�kleniyor");
		uyrukListe = dataService.getByType(KodluListeTip.UYRUK);
		olcuBirimListe = dataService.getByType(KodluListeTip.OLCU_BIRIMI);
		paraBirimListe = dataService.getByType(KodluListeTip.PARA_BIRIM);
		logger.info("Referans Data Y�klendi");
	}

	public List<KodluListe> getOlcuBirimListe() {
		return olcuBirimListe;
	}

	public List<KodluListe> getParaBirimListe() {
		return paraBirimListe;
	}

	public List<KodluListe> getUyrukListe() {
		return uyrukListe;
	}
}

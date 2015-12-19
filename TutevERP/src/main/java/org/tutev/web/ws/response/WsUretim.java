package org.tutev.web.ws.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.uretim.Malzeme;

@XmlRootElement(name="GnlUretim")
public class WsUretim {
	
	Long id;
	String uretimNo;
	Long miktar;
	Date tarih;
	 
	public Long getId() {
		return id;
	}

	@XmlElement(name="uretimNo")
	public String getUretimNo() {
		return uretimNo;
	}

	public void setUretimNo(String uretimNo) {
		this.uretimNo = uretimNo;
	}
	
	@XmlElement(name="miktar")
	public Long getMiktar() {
		return miktar;
	}

	public void setMiktar(Long miktar) {
		this.miktar = miktar;
	}
	
	@XmlElement(name="tarih")
	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

}

package org.tutev.web.ws.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.stokhareket.Irsaliye;

@XmlRootElement(name="Fatura")
public class WsFatura {

	private Long id;
    private String faturaNo;
    private Date faturaTarihi;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name="faturano")
	public String getFaturaNo() {
		return faturaNo;
	}
	public void setFaturaNo(String faturaNo) {
		this.faturaNo = faturaNo;
	}
	public Date getFaturaTarihi() {
		return faturaTarihi;
	}
	public void setFaturaTarihi(Date faturaTarihi) {
		this.faturaTarihi = faturaTarihi;
	}


	
}

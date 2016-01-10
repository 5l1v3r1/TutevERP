/**
 * 
 */
package org.tutev.web.erp.entity.stokhareket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.web.erp.entity.base.Adres;
import org.tutev.web.erp.entity.base.BaseEntity;

/**
 * @author gemini
 *
 */
@Entity
@Table(name="IRS_FIRMA")
public class Firma extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2191718218764772861L;
	private Long id;
	private String name;
	private Adres adres;
	private String tel;
	private String fax;
	private String yetkili;
	private String yetkiliMail;
	private String aktif;

	/**
	 * No param constructor
	 */
	public Firma(){
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param adres
	 * @param tel
	 * @param fax
	 * @param yetkili
	 * @param yetkiliMail
	 * @param aktif
	 */
	public Firma(Long id, String name, Adres adres, String tel, String fax, String yetkili, String yetkiliMail,
			String aktif) {
		this.id = id;
		this.name = name;
		this.adres = adres;
		this.tel = tel;
		this.fax = fax;
		this.yetkili = yetkili;
		this.yetkiliMail = yetkiliMail;
		this.aktif = aktif;
	}
	/**
	 * @return the id of the firma
	 */
	@Id
	//@SequenceGenerator(name = "SQ_IRS_FIRMA_ID", sequenceName = "SQ_IRS_FIRMA_ID", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(generator = "SQ_IRS_FIRMA_ID", strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the adres
	 */
	public Adres getAdres() {
		return adres;
	}
	/**
	 * @param adres the adres to set
	 */
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the yetkili
	 */
	public String getYetkili() {
		return yetkili;
	}
	/**
	 * @param yetkili the yetkili to set
	 */
	public void setYetkili(String yetkili) {
		this.yetkili = yetkili;
	}
	/**
	 * @return the yetkiliMail
	 */
	public String getYetkiliMail() {
		return yetkiliMail;
	}
	/**
	 * @param yetkiliMail the yetkiliMail to set
	 */
	public void setYetkiliMail(String yetkiliMail) {
		this.yetkiliMail = yetkiliMail;
	}
	/**
	 * @return the aktif
	 */
	public String getAktif() {
		return aktif;
	}
	/**
	 * @param aktif the aktif to set
	 */
	public void setAktif(String aktif) {
		this.aktif = aktif;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Firma [Id=" + id + ", name=" + name + ", adres=" + adres + ", tel=" + tel + ", fax=" + fax
				+ ", yetkili=" + yetkili + ", yetkiliMail=" + yetkiliMail + ", aktif=" + aktif + "]";
	}

}

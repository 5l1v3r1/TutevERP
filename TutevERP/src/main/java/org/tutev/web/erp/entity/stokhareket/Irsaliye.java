/**
 * 
 */
package org.tutev.web.erp.entity.stokhareket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.tutev.web.erp.entity.base.Adres;
import org.tutev.web.erp.entity.base.BaseEntity;

/**
 * Stok giriþ ve çýkýþ iþlemleri için kullanýlan irsaliyelerin iþlenmesi için
 * kullanýlýr.
 * 
 * @author Mehmet Emin IÞIK
 * 
 */

@SuppressWarnings("deprecation")
@Entity
@Table(name = "IRS_IRSALIYE")
public class Irsaliye extends BaseEntity {
	/**
	 * Generated Serial Id 
	 */
	private static final long serialVersionUID = -630615291362114642L;
	private Long id;
	private String tur;
	private Date tarih;
	private Firma firmaId;
	private Adres adres;
	private Depo depo;

	/**
	 * Default parametresiz constructor
	 * 
	 * @author Mehmet Emin IÞIK
	 */
	public Irsaliye() {
		adres = new Adres();
	}

	/**
	 * @param id
	 * @param tur
	 * @param tarih
	 * @param firmaId
	 * @param adres
	 */
	public Irsaliye(Irsaliye irsaliye) {
		this.id = irsaliye.id;
		this.tur = irsaliye.tur;
		this.tarih = irsaliye.tarih;
		this.firmaId = irsaliye.firmaId;
		this.adres = new Adres(irsaliye.adres);
	}

	/**
	 * Constructor which initializes all object variables
	 * 
	 * @author Mehmet Emin IÞIK
	 * 
	 * @param id
	 * @param tur
	 * @param tarih
	 * @param firma_id
	 * @param adres
	 */
	public Irsaliye(Long id, String tur, Date tarih, Firma firma_id, Adres adres) {
		this.id = id;
		this.tur = tur;
		this.tarih = tarih;
		this.firmaId = firma_id;
		this.adres = new Adres(adres);
	}

	@Id
	@SequenceGenerator(name = "SQ_IRSALIYE", sequenceName = "SQ_IRSALIYE", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_IRSALIYE", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TUR", length = 2)
	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	@Column(name = "TARIH")
	@Temporal(TemporalType.DATE)
	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public void setTarih(String tarih) throws ParseException {
		// this.tarih = new Date(tarih);
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			this.tarih = df.parse(tarih);
		} catch (ParseException e) {
			e.printStackTrace();
			this.tarih = new Date();
		}
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FIRMA_ID", referencedColumnName="ID")
	@ForeignKey(name="FK_IRSALIYE_REF_FIRMA")
	public Firma getFirma() {
		return firmaId;
	}

	public void setFirma(Firma firma) {
		this.firmaId = firma;
	}

	@Embedded
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	/**
	 * @return the cikisDepo
	 */
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DEPO_ID", referencedColumnName="ID")
	@ForeignKey(name="FK_IRSALIYE_REF_DEPO")
	public Depo getDepo() {
		return depo;
	}

	/**
	 * @param cikisDepo the cikisDepo to set
	 */
	public void setDepo(Depo depo) {
		this.depo = depo;
	}

	@Override
	public String toString() {
		return "Irsaliye : id=" + getId() + " tur=" + this.tur + " tarih=" + this.tarih + " firma_id=" + this.firmaId
				+ " adres=" + this.adres;
	}

}

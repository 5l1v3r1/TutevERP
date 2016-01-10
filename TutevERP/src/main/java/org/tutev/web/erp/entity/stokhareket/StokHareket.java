/**
 * 
 */
package org.tutev.web.erp.entity.stokhareket;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.tutev.web.erp.entity.base.BaseEntity;

/**
 * Stoklardaki malzemelerin giriþ / çýkýþ hareketleri için kullanýlan sýnýftýr.
 * 
 * @author gemini
 *
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "IRS_HAREKET", indexes = { @Index(name = "IRS_HAREKET_IX1", columnList = "TARIH"),
		@Index(name = "IRS_HAREKET_IX2", columnList = "MLZ_ID") })
public class StokHareket extends BaseEntity {
	/**
	 * Generated Serial Id
	 */
	private static final long serialVersionUID = 7072124165426414348L;
	private Long id;
	private Long irsaliyeId;
	private StokHrkMalzeme stokHrkMalzeme;
	private Date tarih;
	private Double fiyat;
	private Double miktar;
	private String birim;
	private Double iskonto;
	private Double tutar;

	/**
	 * @return the id
	 */
	@Id
	//@SequenceGenerator(name = "SQ_STOKHAREKET", sequenceName = "SQ_STOKHAREKET", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(generator = "SQ_STOKHAREKET", strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the irsaliyeId
	 */
//	@ManyToOne
//	@JoinColumn(name = "IRS_ID", referencedColumnName = "ID")
//	@ForeignKey(name = "FK_STOKHRK_REF_IRSALIYE")
	@Column(name="IRS_ID")
	public Long getIrsaliyeId() {
		return irsaliyeId;
	}

	/**
	 * @param irsaliyeId the irsaliyeId to set
	 */
	public void setIrsaliyeId(Long irsaliyeId) {
		this.irsaliyeId = irsaliyeId;
	}

	/**
	 * StokHrkMalzeme nesnesini alýr.
	 * 
	 * @return stokHrkMalzeme
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MLZ_ID", referencedColumnName="ID")
	@ForeignKey(name = "FK_IRS_STOKHRK_REF_MALZEME")
	public StokHrkMalzeme getStokHrkMalzeme() {
		return stokHrkMalzeme;
	}

	/**
	 * stokHrkMalzeme object is set.
	 * 
	 * @param stokHrkMalzeme
	 *            the stokHrkMalzeme to set
	 */
	public void setStokHrkMalzeme(StokHrkMalzeme stokHrkMalzeme) {
		this.stokHrkMalzeme = stokHrkMalzeme;
	}

	/**
	 * @return the tarih
	 */
	@Column(name = "TARIH", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTarih() {
		return tarih;
	}

	/**
	 * @param tarih
	 *            the tarih to set
	 */
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	/**
	 * @return the miktar
	 */
	@Column(name = "MIKTAR", precision = 12, scale = 4, nullable = false)
	public Double getMiktar() {
		return miktar;
	}

	/**
	 * @param miktar
	 *            the miktar to set
	 */
	public void setMiktar(Double miktar) {
		this.miktar = miktar;
	}

	/**
	 * @return the birim
	 */
	@Column(name = "BIRIM", length = 5, nullable = false)
	public String getBirim() {
		return birim;
	}

	/**
	 * @param birim
	 *            the birim to set
	 */
	public void setBirim(String birim) {
		this.birim = birim;
	}

	/**
	 * @return the fiyat
	 */
	@Column(name = "FIYAT", precision = 12, scale = 4, nullable = false)
	public Double getFiyat() {
		return fiyat;
	}

	/**
	 * @param fiyat
	 *            the fiyat to set
	 */
	public void setFiyat(Double fiyat) {
		this.fiyat = fiyat;
	}

	/**
	 * @return the tutar
	 */
	@Column(name = "TUTAR", precision = 12, scale = 2)
	public Double getTutar() {
		return tutar;
	}

	/**
	 * @param tutar
	 *            the tutar to set
	 */
	public void setTutar(Double tutar) {
		this.tutar = tutar;
	}

	/**
	 * @return the iskonto
	 */
	@Column(name = "ISKONTO", precision = 5, scale = 2)
	public Double getIskonto() {
		return iskonto;
	}

	/**
	 * @param iskonto
	 *            the iskonto to set
	 */
	public void setIskonto(Double iskonto) {
		this.iskonto = iskonto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StokHareket [id=" + id + ", stokHrkMalzeme=" + stokHrkMalzeme + ", tarih=" + tarih + ", fiyat=" + fiyat + ", miktar="
				+ miktar + ", birim=" + birim + ", iskonto=" + iskonto + ", tutar=" + tutar + "]";
	}
	
}

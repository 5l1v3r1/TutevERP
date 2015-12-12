/**
 * 
 */
package org.tutev.web.erp.entity.stokhareket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.tutev.web.erp.entity.base.BaseEntity;
import org.tutev.web.erp.entity.genel.KodluListe;

/**
 * @author gemini
 *
 */
@Entity
@Table(name="IRS_DEPO", uniqueConstraints={@UniqueConstraint(name="IRS_DEPO_KODU_UC1",columnNames={"DEPO_KODU"})}, indexes={@Index(name="IRS_DEPO_KODU_IX1", columnList="DEPO_KODU"), @Index(name="IRS_DEPO_ADI", columnList="DEPO_ADI")})
public class Depo extends BaseEntity {
	/**
	 * Generated Serial Id
	 */
	private static final long serialVersionUID = 3951228488405913371L;
	Long id;
	String depoKodu;
	String depoAdi;
	String depoYeri;
	KodluListe depoTuru;
	Boolean aktif;
	
	/**
	 * @return the id
	 */
	@Id
	@SequenceGenerator(name = "SQ_DEPO_ID", sequenceName = "SQ_DEPO_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_DEPO_ID", strategy = GenerationType.SEQUENCE)
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
	 * @return the depoKodu
	 */
	@Column(name = "DEPO_KODU", length=5, nullable=false)
	public String getDepoKodu() {
		return depoKodu;
	}
	/**
	 * @param depoKodu the depoKodu to set
	 */
	public void setDepoKodu(String depoKodu) {
		this.depoKodu = depoKodu;
	}
	/**
	 * @return the depoAdi
	 */
	@Column(name = "DEPO_ADI", length=100)
	public String getDepoAdi() {
		return depoAdi;
	}
	/**
	 * @param depoAdi the depoAdi to set
	 */
	public void setDepoAdi(String depoAdi) {
		this.depoAdi = depoAdi;
	}
	/**
	 * @return the depoYeri
	 */
	@Column(name = "DEPO_YERI", length=100)
	public String getDepoYeri() {
		return depoYeri;
	}
	/**
	 * @param depoYeri the depoYeri to set
	 */
	public void setDepoYeri(String depoYeri) {
		this.depoYeri = depoYeri;
	}
	/**
	 * @return the depoTuru
	 */
	@Column(name = "DEPO_TURU", length=5)
	public KodluListe getDepoTuru() {
		return depoTuru;
	}
	/**
	 * @param depoTuru the depoTuru to set
	 */
	public void setDepoTuru(KodluListe depoTuru) {
		this.depoTuru = depoTuru;
	}
	/**
	 * @return the aktif
	 */
	@Column(name="AKTIF")
	public Boolean getAktif() {
		return aktif;
	}
	/**
	 * @param aktif the aktif to set
	 */
	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Depo [id=" + id + ", depoKodu=" + depoKodu + ", depoAdi=" + depoAdi + ", depoYeri=" + depoYeri
				+ ", depoTuru=" + depoTuru + " aktif=" + aktif + "]";
	}

}

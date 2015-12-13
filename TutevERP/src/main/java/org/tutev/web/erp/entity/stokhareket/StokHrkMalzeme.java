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
@Table(name="IRS_MALZEME", uniqueConstraints={@UniqueConstraint(name="IRS_MALZEME_MLZ_KODU_UC1",columnNames={"MLZ_KODU"})}, indexes={@Index(name="IRS_MALZEME_MLZ_KODU_UC1", unique=true, columnList = "MLZ_KODU"),@Index(name="IRS_MALZEME_IX2", columnList = "MLZ_ADI")})
public class StokHrkMalzeme extends BaseEntity {
	/**
	 * Generated Serial Id
	 */
	private static final long serialVersionUID = 4681755682079952378L;
	Long id;
	String kodu;
	String adi;
	Double minAmount;
	Double maxAmount;
	KodluListe birim;
	KodluListe birimAlternate;
	Boolean aktif;
	
	public StokHrkMalzeme() {

	}
	/**
	 * @param id
	 * @param kodu
	 * @param adi
	 * @param minAmount
	 * @param maxAmount
	 * @param birim
	 * @param birimAlternate
	 */
	public StokHrkMalzeme(Long id, String kodu, String adi, Double minAmount, Double maxAmount, KodluListe birim, KodluListe birimAlternate) {
		this.id = id;
		this.kodu = kodu;
		this.adi = adi;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.birim = birim;
		this.birimAlternate = birimAlternate;
		this.aktif = true;
	}
	/**
	 * @return the id
	 */
	@Id
	@SequenceGenerator(name = "SQ_IRS_MALZEME_ID", sequenceName = "SQ_IRS_MALZEME_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_IRS_MALZEME_ID", strategy = GenerationType.SEQUENCE)
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
	 * @return the kodu
	 */
	@Column(name="MLZ_KODU",length=10,nullable=false)
	public String getKodu() {
		return kodu;
	}
	/**
	 * @param kodu the kodu to set
	 */
	public void setKodu(String kodu) {
		this.kodu = kodu;
	}
	/**
	 * @return the adi
	 */
	@Column(name="MLZ_ADI", length=250, nullable=false)
	public String getAdi() {
		return adi;
	}
	/**
	 * @param adi the adi to set
	 */
	public void setAdi(String adi) {
		this.adi = adi;
	}
	/**
	 * Stoktaki minimum miktar
	 * 
	 * @return the minAmount
	 */
	@Column(name = "MIN_AMOUNT", precision=12, scale=4)
	public Double getMinAmount() {
		return minAmount;
	}
	/**
	 * @param minValue the minValue to set
	 */
	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}
	/**
	 * @return the maxValue
	 */
	@Column(name = "MAX_AMOUNT", precision=12, scale=4)
	public Double getMaxAmount() {
		return maxAmount;
	}
	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}
	/**
	 * @return the birim
	 */
	@Column(name = "BIRIM", length=5, nullable=false)
	public KodluListe getBirim() {
		return birim;
	}
	/**
	 * @param birim1 the birim to set
	 */
	public void setBirim(KodluListe birim) {
		this.birim = birim;
	}
	/**
	 * @return the birimAlternate
	 */
	@Column(name = "BIRIM_ALT", length=5)
	public KodluListe getBirimAlternate() {
		return birimAlternate;
	}
	/**
	 * @param birimAlternate the alternate birim to set
	 */
	public void setBirimAlternate(KodluListe birimAlternate) {
		this.birimAlternate = birimAlternate;
	}
	/**
	 * @return the aktif
	 */
	@Column(name = "AKTIF")
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
		return "StokHrkMalzeme [id=" + id + ", kodu=" + kodu + ", adi=" + adi + ", minAmount=" + minAmount + ", maxAmount="
				+ maxAmount + ", birim=" + birim + ", birimAlternate=" + birimAlternate + " aktif=" + aktif + "]";
	}

}

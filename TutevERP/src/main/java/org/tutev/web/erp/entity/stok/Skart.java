package org.tutev.web.erp.entity.stok;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.tutev.web.erp.entity.base.BaseEntity;
import org.tutev.web.erp.entity.genel.KodluListe;

//Specifies that the class is an entity-it must have a no-argument constructor
@SuppressWarnings("deprecation")
//to specify the details of the table that will be used to persist the entity
//in the database
@Entity
@Table(name = "STK_SKART")
public class Skart extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4042824433716903674L;

	private Long id;
	private String kod;
	private SkartKategori skartKategori;
	private String tanim;
	private SkartMarkaModel skartMarkaModel;
	private String barkod;
	private KodluListe paraBirimi;
	private BigDecimal birimFiyat;
	private KodluListe olcuBirimi;

	@Id
	// Each entity bean will have a primary key
	@SequenceGenerator(name = "SQ_SKART_ID", sequenceName = "SQ_SKART_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_SKART_ID", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	// to specify the details of the column to which a field or property will be
	// mapped
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "KOD", length = 80)
	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKART_KATEGORI_ID")
    @ForeignKey(name = "FK_SKART_KATEGORI_ID")
	public SkartKategori getSkartKategori() {
		return skartKategori;
	}

	public void setSkartKategori(SkartKategori skartKategori) {
		this.skartKategori = skartKategori;
	}

	@Column(name = "TANIM", length = 400)
	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKART_MARKAMODEL_ID")
    @ForeignKey(name = "FK_SKART_MARKAMODEL_ID")
	public SkartMarkaModel getSkartMarkaModel() {
		return skartMarkaModel;
	}

	public void setSkartMarkaModel(SkartMarkaModel skartMarkaModel) {
		this.skartMarkaModel = skartMarkaModel;
	}

	@Column(name = "BARKOD", length = 100)
	public String getBarkod() {
		return barkod;
	}

	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARA_BIRIMI_ID")
    @ForeignKey(name = "FK_PARA_BIRIMI_ID")
	public KodluListe getParaBirimi() {
		return paraBirimi;
	}

	public void setParaBirimi(KodluListe paraBirimi) {
		this.paraBirimi = paraBirimi;
	}

	@Column(name = "BIRIM_FIYAT")	
	public BigDecimal getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(BigDecimal birimFiyat) {
		this.birimFiyat = birimFiyat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OLCU_BIRIMI_ID")
    @ForeignKey(name = "FK_OLCU_BIRIMI_ID")
	public KodluListe getOlcuBirimi() {
		return olcuBirimi;
	}

	public void setOlcuBirimi(KodluListe olcuBirimi) {
		this.olcuBirimi = olcuBirimi;
	}

}

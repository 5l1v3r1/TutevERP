/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.entity.uretim;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.tutev.web.erp.entity.base.BaseEntity;
import org.tutev.web.erp.entity.genel.KodluListe;

/**
 * 
 * @author Erhan Kose
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "URT_URETIM")
public class Uretim extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2032781563357516372L;

	public Uretim() {
	}

	public Uretim(Long id, String uretimNo, Long miktar, Date tarih,
			Malzeme malzeme,KodluListe uretimTipi) {
		this.id = id;
		this.uretimNo = uretimNo;
		this.miktar = miktar;
		this.tarih = tarih;
		this.malzeme = malzeme;

	}

	private Long id;
	private String uretimNo;
	private Long miktar;
	private Date tarih;
	private Malzeme malzeme;
	private KodluListe uretimTipi;
	
	
	@Id
	//@SequenceGenerator(name = "SQ_URETIM", sequenceName = "SQ_URETIM", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(generator = "SQ_URETIM", strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "URETIM_NO", length = 20)
	public String getUretimNo() {
		return uretimNo;
	}

	public void setUretimNo(String uretimNo) {
		this.uretimNo = uretimNo;
	}

	@Column(name = "MIKTAR")
	public Long getMiktar() {
		return miktar;
	}

	public void setMiktar(Long miktar) {
		this.miktar = miktar;
	}

	@Column(name = "TARIH")
	@Temporal(TemporalType.DATE)
	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "malzeme_id")
	@ForeignKey(name = "FK_URETIM_MALZEME")
	public Malzeme getMalzeme() {
		return malzeme;
	}

	public void setMalzeme(Malzeme malzeme) {
		this.malzeme = malzeme;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "URETIM_ID")
    @ForeignKey(name = "FK_URETIM_ID")
    public KodluListe getUretimTipi() {
		return uretimTipi;
	}

	public void setUretimTipi(KodluListe uretimTipi) {
		this.uretimTipi = uretimTipi;
	}

	
	@Override
	public String toString() {
		return "Uretim{" + "id=" + id + "Miktar" + miktar + " Tarihi=" + tarih
				+ "StokHrkMalzeme "+ malzeme.getMalzemeAd()+'}';
	}

}

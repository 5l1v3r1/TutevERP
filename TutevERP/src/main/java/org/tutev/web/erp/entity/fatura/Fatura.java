/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.entity.fatura;

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
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.stokhareket.Irsaliye;

@SuppressWarnings("deprecation")
@Entity
@Table(name="FTR_FATURA")
public class Fatura extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4515466884808962859L;
	private Long id;
    private String faturaNo;
    private KodluListe faturaTipi;
    private Date faturaTarihi;
    private Kisi musteri;
    private Irsaliye irsaliye;

    
    @Id
   // //@GeneratedValue(generator = "SQ_FATURA", strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
    //@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SQ_FATURA", sequenceName = "SQ_FATURA")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FATURA_NO")
    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FATURA_TIP_ID")
    @ForeignKey(name = "FK_FATURA_TIP_ID")
    public KodluListe getFaturaTipi() {
        return faturaTipi;
    }

    public void setFaturaTipi(KodluListe faturaTipi) {
        this.faturaTipi = faturaTipi;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FATURA_TARIHI")
    public Date getFaturaTarihi() {
        return faturaTarihi;
    }

    public void setFaturaTarihi(Date faturaTarihi) {
        this.faturaTarihi = faturaTarihi;
    }
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSTERI_ID")
    @ForeignKey(name = "FK_MUSTERI_ID")
    public Kisi getMusteri() {
		return musteri;
	}
    
    public void setMusteri(Kisi musteri) {
		this.musteri = musteri;
	}
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IRSALIYE_ID")
    @ForeignKey(name = "FK_IRSALIYE_ID")
    public Irsaliye getIrsaliye() {
		return irsaliye;
	}
    
    public void setIrsaliye(Irsaliye irsaliye) {
		this.irsaliye = irsaliye;
	}
}

package org.tutev.web.erp.entity.stok;

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


@SuppressWarnings("deprecation")
@Entity
@Table(name = "STK_SKART_MARKAMODEL")
public class SkartMarkaModel extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1870555804036362088L;
	private Long id;
	private String kod;
	private String tanim;
	private SkartMarkaModel ustMarkaModel;

	@Id
	//@SequenceGenerator(name = "SQ_SKART_KATEGORI", sequenceName = "SQ_SKART_KATEGORI", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(generator = "SQ_SKART_KATEGORI", strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
	@Column(name = "ID")
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

	@Column(name = "TANIM", length = 400)
	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UST_MARKAMODEL_ID")
    @ForeignKey(name = "FK_UST_MARKAMODEL_ID")
	public SkartMarkaModel getUstMarkaModel() {
		return ustMarkaModel;
	}

	public void setUstMarkaModel(SkartMarkaModel ustMarkaModel) {
		this.ustMarkaModel = ustMarkaModel;
	}

}

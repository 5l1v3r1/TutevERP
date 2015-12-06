package org.tutev.web.erp.entity.genel;

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
@Table(name = "GNL_YERLESIM")
public class Yerlesim extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2298693321906588025L;
	
	private Long id;
	private String kod;
	private String tanim;
	private KodluListe yerlesimTip;

	@Id
	@SequenceGenerator(name = "SQ_YERLESIM", sequenceName = "SQ_YERLESIM", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_YERLESIM", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
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
    @JoinColumn(name = "YERLESIM_TIP_ID")
    @ForeignKey(name = "FK_YERLESIM_TIP_ID")
	public KodluListe getYerlesimTip() {
		return yerlesimTip;
	}

	public void setYerlesimTip(KodluListe yerlesimTip) {
		this.yerlesimTip = yerlesimTip;
	}

}

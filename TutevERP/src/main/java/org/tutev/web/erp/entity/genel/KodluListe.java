package org.tutev.web.erp.entity.genel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.web.erp.entity.base.BaseEntity;

@Entity
@Table(name = "GNL_KODLU_LISTE")
public class KodluListe extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1919508622085704230L;
	private Long id;
	private String kod;
	private String tanim;
	private KodluListeTip kodluListeTip; 

	@Id
	@SequenceGenerator(name = "SQ_KODLU_LISTE", sequenceName = "SQ_KODLU_LISTE", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_KODLU_LISTE", strategy = GenerationType.SEQUENCE)
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

	public KodluListeTip getKodluListeTip() {
		return kodluListeTip;
	}
	
	public void setKodluListeTip(KodluListeTip kodluListeTip) {
		this.kodluListeTip = kodluListeTip;
	}
}

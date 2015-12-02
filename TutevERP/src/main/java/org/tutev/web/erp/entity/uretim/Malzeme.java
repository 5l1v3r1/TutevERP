/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.entity.uretim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.web.erp.entity.base.BaseEntity;

/**
 * 
 * @author Erhan Kose
 */
@Entity
@Table(name = "URT_MALZEME")
public class Malzeme extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -309374331443265793L;
	private String malzemeAd;
	private Long malzemeId;
	
	public Malzeme() {
	}

	public Malzeme(Long malzemeId,String malzemeAd) {
		this.malzemeId=malzemeId;
		this.malzemeAd=malzemeAd;
		
	}
	

	@Id
	@SequenceGenerator(name = "SQ_MALZEME", sequenceName = "SQ_MALZEME", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_MALZEME", strategy = GenerationType.SEQUENCE)
	@Column(name = "MALZEME_ID")	 	
	public Long getMalzemeId() {
		return malzemeId;
	}

	public void setMalzemeId(Long malzemeId) {
		this.malzemeId = malzemeId;
	}

	@Column(name = "MALZEME_AD")
	public String getMalzemeAd() {
		return malzemeAd;
	}

	public void setMalzemeAd(String malzemeAd) {
		this.malzemeAd = malzemeAd;
	}

	@Override
	public String toString() {
		return "Malzeme{" + "malzemeId= " + malzemeId + "  malzemeAd :" + malzemeAd+ '}';
	}
 
 

}

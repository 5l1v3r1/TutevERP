/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.entity.base;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bilisim-Hoca
 */
@SuppressWarnings("serial")
@Embeddable
public class Adres implements Serializable {

	String tel;
	String mail;
	String acikAdres;
	String pk;

	/**
	 * Baz� b�l�mlerin �al��mas� i�in parametresiz constructor istiyordu.
	 * 
	 * @author Mehmet Emin I�IK
	 */
	public Adres() {

	}

	/**
	 * Kay�tlar�n eklenmesi s�ras�nda tek tek set etmektense b�yle bir constructor
	 * adres objesinin kolayl�kla olu�turulmas�n� sa�lamak amac�yla olu�turuldu.
	 * 
	 * @author Mehmet Emin I�IK a.k.a. gemini
	 * @param adres
	 */
	public Adres(Adres adres) {
		this();
		this.tel = adres.tel;
		this.mail = adres.mail;
		this.acikAdres = adres.acikAdres;
		this.pk = adres.pk;
	}
	
	/**
	 * Kay�tlar�n eklenmesi s�ras�nda tek tek set etmektense b�yle bir constructor
	 * adres objesinin kolayl�kla olu�turulmas�n� sa�lamak amac�yla olu�turuldu.
	 * 
	 * @param tel
	 * @param mail
	 * @param acikAdres
	 * @param pk
	 */
	public Adres(String tel, String mail, String acikAdres, String pk) {
		super();
		this.tel = tel;
		this.mail = mail;
		this.acikAdres = acikAdres;
		this.pk = pk;
	}

	@Column(name = "TEL", length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "MAIL", length = 100)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// @Lob
	@Column(name = "ACIK_ADRES", length = 400)
	public String getAcikAdres() {
		return acikAdres;
	}

	public void setAcikAdres(String acikAdres) {
		this.acikAdres = acikAdres;
	}

	@Column(name = "POSTA_KUTUSU", length = 400)
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	@Override
	public String toString() {
		return "Adres [tel=" + tel + ", mail=" + mail + ", acikAdres=" + acikAdres + ", pk=" + pk + "]";
	}
	
	

}

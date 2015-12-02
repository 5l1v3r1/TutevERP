/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.web.erp.entity.base;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bilisim-Hoca
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4899459139495335769L;
	String ekleyen;
    String guncelleyen;
    Date eklemeTarihi;
    Date guncellemeTarihi;
    Boolean durum;

    @Column(name = "CRTR",length = 100)
    public String getEkleyen() {
        return ekleyen;
    }

    public void setEkleyen(String ekleyen) {
        this.ekleyen = ekleyen;
    }

    @Column(name = "UPDTR",length = 100)
    public String getGuncelleyen() {
        return guncelleyen;
    }

    public void setGuncelleyen(String guncelleyen) {
        this.guncelleyen = guncelleyen;
    }

    @Column(name = "CRTM")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEklemeTarihi() {
        return eklemeTarihi;
    }

    public void setEklemeTarihi(Date eklemeTarihi) {
        this.eklemeTarihi = eklemeTarihi;
    }

    @Column(name = "UPDTM")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(Date guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    @Column(name = "STATE")
    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;
import org.tutev.web.erp.entity.base.BaseEntity;

/**
 *
 * @author Bilisim-Hoca
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "AUT_USERS",uniqueConstraints=@UniqueConstraint(name="UK_USERNAME",columnNames={"USERNAME"}))
public class Kullanici extends  BaseEntity{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1102631676506803698L;
	private Long id;
    private String username;
    private String password;
    private Kisi kisi;

    @Id
    //@SequenceGenerator(name = "SQ_KULLANICI",sequenceName = "SQ_KULLANICI",allocationSize = 1,initialValue = 1)
   // //@GeneratedValue(generator = "SQ_KULLANICI",strategy = GenerationType.SEQUENCE 
     @GeneratedValue()
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length=100,name="USERNAME",unique=true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KISI_ID")
    @ForeignKey(name = "FK_KISI_KULLANICI")
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
       
}

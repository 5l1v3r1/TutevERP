package org.tutev.web.erp.entity.ik;

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

@SuppressWarnings("deprecation")
@Entity
@Table(name = "GNL_PERSONEL")
public class Personel  extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4487587361104486967L;
	private Long Id;
	private Kisi kisi;
	private KodluListe uyruk;
	private String departman;
	private String isGurubu;
	private Date girisTarihi;
	private String istihtamDurum;
	
	
	

	public Personel( String departman, String isGurubu,Date girisTarihi, String istihtamDurum) {
		super();
		this.departman = departman;
		this.isGurubu = isGurubu;
		this.girisTarihi = girisTarihi;
		this.istihtamDurum = istihtamDurum;
	}

	@Id
	@SequenceGenerator(name = "SQ_PERSONEL_ID", sequenceName = "SQ_PERSONEL_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "SQ_PERSONEL_ID", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UYRUK_ID")
    @ForeignKey(name = "FK_UYRUK_ID")
	public KodluListe getUyrugu() {
		return uyruk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KISI_ID")
    @ForeignKey(name = "FK_KISI_ID")
	public Kisi getKisi() {
		return kisi;
	}
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	
	public void setUyruk(KodluListe uyruk) {
		this.uyruk = uyruk;
	}

	@Column(name = "departman", length = 80)
	public String getDepartman() {
		return departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}

	@Column(name = "isgurubu", length = 80)
	public String getIsGurubu() {
		return isGurubu;
	}

	public void setIsGurubu(String isGurubu) {
		this.isGurubu = isGurubu;
	}

	@Column(name = "giristarihi", length = 80)
	@Temporal(TemporalType.DATE)
	public Date getGirisTarihi() {
		return girisTarihi;
	}

	public void setGirisTarihi(Date girisTarihi) {
		this.girisTarihi = girisTarihi;
	}

	@Column(name = "istihtamdurum", length = 80)
	public String getIstihtamDurum() {
		return istihtamDurum;
	}

	public void setIstihtamDurum(String istihtamDurum) {
		this.istihtamDurum = istihtamDurum;
	}

}

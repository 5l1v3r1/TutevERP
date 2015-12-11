package org.tutev.web.erp.controller.stok;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.stok.SkartKategori;
import org.tutev.web.erp.service.stok.StokKategoriService;



@Controller("stokKategoriController")
@Scope("session")
public class StokKategoriController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730517198446680077L;

	//http://localhost:8080/TutevERP/secure/stok/index.xhtml
    	
	@Autowired         
	private transient StokKategoriService stokKategoriService;   //wired the beans automatically

	private SkartKategori stokKartKategori;  //created variable  for stokKart object
	List<SkartKategori> stokKategoriListesi;  //created variable for List of stokKart objects
		
	@PostConstruct  
	private void init() {   ////the contract that guarantees that this method will be invoked only once in the bean lifecycle
		stokKategoriListesi=stokKategoriService.getAll();  //assigned values by using getAll method in StokService 
		
		//stokListele();
	}
    		
	public void stokKategoriListele() {
		setStokKategoriListesi(stokKategoriService.getAll());
	}
				
	public void stokKategoriSil(Long id) {
		SkartKategori silinecekstokKartKategori = stokKategoriService.getById(id);
		stokKategoriService.delete(silinecekstokKartKategori);
		stokKategoriListesi=stokKategoriService.getAll();

	}
	
	
	public void stokKategoriDuzenle(Long id) {
		stokKartKategori = stokKategoriService.getById(id);
	}
	
	
	public void yeni() {
		stokKartKategori=null;
	}
	
	
	 
	
	public void stokKategoriKaydet() {
		try {
			if(stokKartKategori.getId()==null){
				stokKategoriService.save(stokKartKategori);
			}else{
				stokKategoriService.update(stokKartKategori);}		
			System.out.println("Yeni Stok Kategori Kaydi yapildi");
			stokKategoriListele();
			} catch (Exception e) {
		}	
	}
	
	public void stokDeleteByKod() {
		System.out.println("Stok Kaydý Sil");
		for (SkartKategori sk : stokKategoriListesi){
			  System.out.println("stokkodu:"+sk.getKod());
			  System.out.println("girilenkartkodu:"+stokKartKategori.getKod());
			  if (sk.getKod()!=null && sk.getKod().equals(stokKartKategori.getKod())){
				  System.out.println("stokkodu:"+sk.getKod());
				  stokKategoriService.delete(sk);
			  }
		}			  
    	yeniStokKartKategori();
		stokKategoriListele();
	}
	
	public void stokDeleteByUrunAd() {
		System.out.println("Stok Kaydý Sil");
		//TODO
//		for (Skart sk : stokListesi){
//			  System.out.println("stokkodu:"+sk.getUrunAd());
//			  System.out.println("girilenkartkodu:"+stokKart.getUrunAd());
//			  if (sk.getUrunAd()!=null && sk.getUrunAd().equals(stokKart.getUrunAd())){
//				  System.out.println("stokkodu:"+sk.getUrunAd());
//				  stokService.delete(sk);
//			  }
//		}			  
    	yeniStokKartKategori();
		stokKategoriListele();
	}
	
	
			
	public void yeniStokKartKategori() {      //create new stokKart object 
		stokKartKategori = new SkartKategori();
	}


	
	///GET and SET METHODS for variables 

	public List<SkartKategori> getStokKategoriListesi() {
		return stokKategoriListesi;
	}



	public void setStokKategoriListesi(List<SkartKategori> stokKategoriListesi) {
		this.stokKategoriListesi = stokKategoriListesi;
	}
	
	
	public SkartKategori getStokKartKategori() {   
		if(stokKartKategori==null){
			yeniStokKartKategori();
			}	
		return stokKartKategori;
	}	
		
	public void setStokKart(SkartKategori stokKartKategori) {
		this.stokKartKategori=stokKartKategori;
			
	}
}

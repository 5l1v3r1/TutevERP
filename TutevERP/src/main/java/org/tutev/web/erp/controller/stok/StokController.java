package org.tutev.web.erp.controller.stok;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.stok.StokKart;
import org.tutev.web.erp.service.StokService;


@Controller("stokController")
@Scope("session")
public class StokController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730517198446680077L;

	//http://localhost:8080/TutevERP/secure/stok/index.xhtml
    	
	@Autowired         
	private transient StokService stokService;   //wired the beans automatically

	private StokKart stokKart;  //created variable  for stokKart object
	List<StokKart> stokListesi;  //created variable for List of stokKart objects
		
	@PostConstruct  
	private void init() {   ////the contract that guarantees that this method will be invoked only once in the bean lifecycle
		stokListesi=stokService.getAll();  //assigned values by using getAll method in StokService 
		
		//stokListele();
	}
    		
	public void stokListele() {
		setStokListesi(stokService.getAll());
	}
				
	public void stokSil(Long id) {
		StokKart silinecekStokKart = stokService.getById(id);
		stokService.delete(silinecekStokKart);
		stokListesi=stokService.getAll();

	}
	
	
	public void stokDuzenle(Long id) {
		stokKart = stokService.getById(id);
	}
	
	
	public void yeni() {
		stokKart=null;
	}
	
	
	
	
	public void stokKaydet() {
		try {
			if(stokKart.getId()==null){
				stokService.save(stokKart);
			}else{
				stokService.update(stokKart);}		
			System.out.println("Yeni Stok Kaydi yapildi");
			stokListele();
			} catch (Exception e) {
		}	
	}
	
	public void stokDeleteByKod() {
		System.out.println("Stok Kaydý Sil");
		for (StokKart sk : stokListesi){
			  System.out.println("stokkodu:"+sk.getKod());
			  System.out.println("girilenkartkodu:"+stokKart.getKod());
			  if (sk.getKod()!=null && sk.getKod().equals(stokKart.getKod())){
				  System.out.println("stokkodu:"+sk.getKod());
				  stokService.delete(sk);
			  }
		}			  
    	yeniStokKart();
		stokListele();
	}
	
	public void stokDeleteByUrunAd() {
		System.out.println("Stok Kaydý Sil");
		for (StokKart sk : stokListesi){
			  System.out.println("stokkodu:"+sk.getUrunAd());
			  System.out.println("girilenkartkodu:"+stokKart.getUrunAd());
			  if (sk.getUrunAd()!=null && sk.getUrunAd().equals(stokKart.getUrunAd())){
				  System.out.println("stokkodu:"+sk.getUrunAd());
				  stokService.delete(sk);
			  }
		}			  
    	yeniStokKart();
		stokListele();
	}
	
	
			
	public void yeniStokKart() {      //create new stokKart object 
		stokKart = new StokKart();
	}


	
	///GET and SET METHODS for variables 

	public List<StokKart> getStokListesi() {
		return stokListesi;
	}



	public void setStokListesi(List<StokKart> stokListesi) {
		this.stokListesi = stokListesi;
	}
	
	
	public StokKart getStokKart() {   
		if(stokKart==null){
			yeniStokKart();
			}	
		return stokKart;
	}	
		
	public void setStokKart(StokKart stokKart) {
		this.stokKart=stokKart;
			
	}
}

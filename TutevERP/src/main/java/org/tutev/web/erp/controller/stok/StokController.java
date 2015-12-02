package org.tutev.web.erp.controller.stok;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.stok.Skart;
import org.tutev.web.erp.service.stok.StokService;


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

	private Skart stokKart;  //created variable  for stokKart object
	List<Skart> stokListesi;  //created variable for List of stokKart objects
		
	@PostConstruct  
	private void init() {   ////the contract that guarantees that this method will be invoked only once in the bean lifecycle
		stokListesi=stokService.getAll();  //assigned values by using getAll method in StokService 
		
		//stokListele();
	}
    		
	public void stokListele() {
		setStokListesi(stokService.getAll());
	}
				
	public void stokSil(Long id) {
		Skart silinecekStokKart = stokService.getById(id);
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
		for (Skart sk : stokListesi){
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
		//TODO
//		for (Skart sk : stokListesi){
//			  System.out.println("stokkodu:"+sk.getUrunAd());
//			  System.out.println("girilenkartkodu:"+stokKart.getUrunAd());
//			  if (sk.getUrunAd()!=null && sk.getUrunAd().equals(stokKart.getUrunAd())){
//				  System.out.println("stokkodu:"+sk.getUrunAd());
//				  stokService.delete(sk);
//			  }
//		}			  
    	yeniStokKart();
		stokListele();
	}
	
	
			
	public void yeniStokKart() {      //create new stokKart object 
		stokKart = new Skart();
	}


	
	///GET and SET METHODS for variables 

	public List<Skart> getStokListesi() {
		return stokListesi;
	}



	public void setStokListesi(List<Skart> stokListesi) {
		this.stokListesi = stokListesi;
	}
	
	
	public Skart getStokKart() {   
		if(stokKart==null){
			yeniStokKart();
			}	
		return stokKart;
	}	
		
	public void setStokKart(Skart stokKart) {
		this.stokKart=stokKart;
			
	}
}

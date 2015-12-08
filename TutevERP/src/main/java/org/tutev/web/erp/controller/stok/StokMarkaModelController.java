package org.tutev.web.erp.controller.stok;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.stok.SkartMarkaModel;
import org.tutev.web.erp.service.stok.StokMarkaModelService;


@Controller("stokMarkaModelController")
@Scope("session")
public class StokMarkaModelController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730517198446680077L;

	//http://localhost:8080/TutevERP/secure/stok/index.xhtml
    	
	@Autowired         
	private transient StokMarkaModelService stokMarkaModelService;   //wired the beans automatically

	private SkartMarkaModel stokKartMarkaModel;  //created variable  for stokKart object
	List<SkartMarkaModel> stokMarkaModelListesi;  //created variable for List of stokKart objects
		
	@PostConstruct  
	private void init() {   ////the contract that guarantees that this method will be invoked only once in the bean lifecycle
		stokMarkaModelListesi=stokMarkaModelService.getAll();  //assigned values by using getAll method in StokService 
		
		//stokListele();
	}
    		
	public void stokMarkaModelListele() {
		setStokMarkaModelListesi(stokMarkaModelService.getAll());
	}
				
	public void stokMarkaModelSil(Long id) {
		SkartMarkaModel silinecekstokKartMarkaModel = stokMarkaModelService.getById(id);
		stokMarkaModelService.delete(silinecekstokKartMarkaModel);
		stokMarkaModelListesi=stokMarkaModelService.getAll();

	}
	
	
	public void stokMarkaModelDuzenle(Long id) {
		stokKartMarkaModel = stokMarkaModelService.getById(id);
	}
	
	
	public void yeni() {
		stokKartMarkaModel=null;
	}
	
	
	 
	
	public void stokMarkaModelKaydet() {
		try {
			if(stokKartMarkaModel.getId()==null){
				stokMarkaModelService.save(stokKartMarkaModel);
			}else{
				stokMarkaModelService.update(stokKartMarkaModel);}		
			System.out.println("Yeni Stok Kaydi yapildi");
			stokMarkaModelListele();
			} catch (Exception e) {
		}	
	}
	
	public void stokDeleteByKod() {
		System.out.println("Stok Kaydý Sil");
		for (SkartMarkaModel sk : stokMarkaModelListesi){
			  System.out.println("stokkodu:"+sk.getKod());
			  System.out.println("girilenkartkodu:"+stokKartMarkaModel.getKod());
			  if (sk.getKod()!=null && sk.getKod().equals(stokKartMarkaModel.getKod())){
				  System.out.println("stokkodu:"+sk.getKod());
				  stokMarkaModelService.delete(sk);
			  }
		}			  
    	yeniStokKartMarkaModel();
		stokMarkaModelListele();
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
    	yeniStokKartMarkaModel();
		stokMarkaModelListele();
	}
	
	
			
	public void yeniStokKartMarkaModel() {      //create new stokKart object 
		stokKartMarkaModel = new SkartMarkaModel();
	}


	
	///GET and SET METHODS for variables 

	public List<SkartMarkaModel> getStokMarkaModelListesi() {
		return stokMarkaModelListesi;
	}



	public void setStokMarkaModelListesi(List<SkartMarkaModel> stokMarkaModelListesi) {
		this.stokMarkaModelListesi = stokMarkaModelListesi;
	}
	
	
	public SkartMarkaModel getStokKartMarkaModel() {   
		if(stokKartMarkaModel==null){
			yeniStokKartMarkaModel();
			}	
		return stokKartMarkaModel;
	}	
		
	public void setStokKart(SkartMarkaModel stokKartMarkaModel) {
		this.stokKartMarkaModel=stokKartMarkaModel;
			
	}
}

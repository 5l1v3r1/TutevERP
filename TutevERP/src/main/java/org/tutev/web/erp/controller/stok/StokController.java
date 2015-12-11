package org.tutev.web.erp.controller.stok;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.stok.Skart;
import org.tutev.web.erp.entity.stok.SkartKategori;
import org.tutev.web.erp.entity.stok.SkartMarkaModel;
import org.tutev.web.erp.service.KodluListeService;
import org.tutev.web.erp.service.stok.StokKategoriService;
import org.tutev.web.erp.service.stok.StokMarkaModelService;
import org.tutev.web.erp.service.stok.StokService;
import org.tutev.web.erp.util.PageingModel;



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

	@Autowired
	private transient KodluListeService kodluListeService;
	
	@Autowired
	private transient StokKategoriService stokKategoriService;
	
	@Autowired
	private transient StokMarkaModelService stokMarkaModelService;
	
	private Skart stokKart;  //created variable  for stokKart object
	List<Skart> stokListesi;  //created variable for List of stokKart objects
	List<SkartKategori> stokKategoriListesi;	
	LazyDataModel<Skart> lazy;
	private KodluListe filterParaBirim;
	
	
	@PostConstruct  
	private void init() {   ////the contract that guarantees that this method will be invoked only once in the bean lifecycle
		//stokListesi=stokService.getAll();  //assigned values by using getAll method in StokService 
		//stokKategoriListesi = stokKategoriService.getAll();
		//stokListele();
		//stokListele();
		listele();
		
	}

	private void stokListele() {
		stokListesi=stokService.getAll();
		
	}

	public List<KodluListe> acomp(String query) {
		return kodluListeService.acomp(query);
	}			
	
	public void ajaxCall() {
		stokListele();
	}
	
	public void stokSil(Long id) {                         //stok.xhtlm icinde  stokController.stokSil(stkrt.id) ile kullanýldý
		Skart silinecekStokKart = stokService.getById(id);
		stokService.delete(silinecekStokKart);
		//stokListesi=stokService.getAll();
		listele();

	}
	
	public void stokDuzenle(Long id) {             //stok.xhtlm icinde  stokController.stokDuzenle(stkrt.id) ile kullanýldý
		stokKart = stokService.getById(id);
	}
	
	public void yeni() {                     //stok.xhtlm icinde  "#{stokController.yeni}" ile kullanýldý
		stokKart=null;
	}
	
	
	public void stokKaydet() {                   //stok.xhtlm icinde  stokController.stokKaydet  ile kullanýldý
		try {
			if(stokKart.getId()==null){				
				
				stokService.save(stokKart);
				
			}else{
				stokService.update(stokKart);}		
			System.out.println("Yeni Stok Kaydi yapildi");
			//stokListele();
			listele();
			} catch (Exception e) {
		}	
	}
	
/*	public void stokDeleteByKod() {
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
	*/
	
	
	/*
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
	*/
	
			
	public void yeniStokKart() {      //create new stokKart object 
		stokKart = new Skart();
		stokKart.setSkartKategori(new SkartKategori());
		stokKart.setSkartMarkaModel(new SkartMarkaModel());


	}
    
	
	
	
    
    public void listele() {
		
		lazy=new LazyDataModel<Skart>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8057585912284476556L;

			/**
			 * 
			 */
			

			@Override
			public List<Skart> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				
				if(filterParaBirim!=null && filterParaBirim.getId()!=null ){
					filters.put("paraBirimi", filterParaBirim);
				}
				
				PageingModel<Skart> stokkartlar=stokService.getByPageing(first, pageSize, filters);
				lazy.setRowCount(stokkartlar.getRowCount());
				return stokkartlar.getList();
			}

			@Override
			public void forEach(Consumer<? super Skart> arg0) {
				
			}

			@Override
			public Spliterator<Skart> spliterator() {
				return null;
			}
		};

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
	
	public LazyDataModel<Skart> getLazy() {
		return lazy;
	}
	
	
	public KodluListe getFilterParaBirim() {
		if(filterParaBirim==null){
			filterParaBirim=new KodluListe();
		}
		return filterParaBirim;
	}
	
	public void setFilterParaBirim(KodluListe filterParaBirim) {
		this.filterParaBirim = filterParaBirim;
	}
	
}

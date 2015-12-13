package org.tutev.web.erp.controller;

import java.io.Serializable;
import java.io.StringReader;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.util.AppUtils;
import org.tutev.web.erp.util.HavaDurum;

@Controller("homeController")
@Scope("session")
public class HomeController  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1230194639120955098L;
	@Autowired
	private AppUtils appUtils;
	
	
	private HavaDurum havaDurum;

	private String username;
	@PostConstruct
	private void init() {
//		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		username="Taner";
		
	}
	
	public void havaDurumuGetir() {
		try {
			GlobalWeather globalWeather =new GlobalWeather(new URL(appUtils.getWsAdress()));
			GlobalWeatherSoap globalWeatherSoap=globalWeather.getGlobalWeatherSoap();
			String sonuc = globalWeatherSoap.getWeather("Ankara", "Turkey");
			marshaller(sonuc);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public String getUsername() {
		return username;
	}
	
	public HavaDurum getHavaDurum() {
		if(havaDurum==null)
			this.havaDurum=new HavaDurum();
		return havaDurum;
	}
	
	private void marshaller(String xml) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(HavaDurum.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			HavaDurum durum = (HavaDurum) unmarshaller.unmarshal(reader);
			this.havaDurum = durum;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

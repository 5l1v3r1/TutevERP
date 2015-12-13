package org.tutev.web.erp.util;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CurrentWeather")
public class HavaDurum {
	
	private String yer;	
	private String zaman;	
	private String ruzgar;	
	private String gorunurluk;	
	private String sicaklik;	
	private String basinc;

	@XmlElement(name = "Location")
	public String getYer() {
		return yer;
	}

	public void setYer(String yer) {
		this.yer = yer;
	}

	@XmlElement(name = "Time")
	public String getZaman() {
		return zaman;
	}

	public void setZaman(String zaman) {
		this.zaman = zaman;
	}

	@XmlElement(name = "Wind")
	public String getRuzgar() {
		return ruzgar;
	}

	public void setRuzgar(String ruzgar) {
		this.ruzgar = ruzgar;
	}

	@XmlElement(name = "Visibility")
	public String getGorunurluk() {
		return gorunurluk;
	}

	public void setGorunurluk(String gorunurluk) {
		this.gorunurluk = gorunurluk;
	}

	@XmlElement(name = "Temperature")
	public String getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(String sicaklik) {
		this.sicaklik = sicaklik;
	}

	@XmlElement(name = "Pressure")
	public String getBasinc() {
		return basinc;
	}

	public void setBasinc(String basinc) {
		this.basinc = basinc;
	}

}

// <CurrentWeather>
// <Location>Ankara / Etimesgut, Turkey (LTAD) 39-57N 032-41E 806M</Location>
// <Time>Dec 12, 2015 - 11:58 PM EST / 2015.12.13 0458 UTC</Time>
// <Wind> Calm:0</Wind>
// <Visibility> 1 mile(s):0</Visibility>
// <Temperature> 23 F (-5 C)</Temperature>
// <DewPoint> 21 F (-6 C)</DewPoint>
// <RelativeHumidity> 92%</RelativeHumidity>
// <Pressure> 30.18 in. Hg (1022 hPa)</Pressure>
// <Status>Success</Status>
// </CurrentWeather>
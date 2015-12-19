package org.tutev.web.ws.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Stock")
public class WsStok {

	Long id;
	String stokTanim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="stockname")
	public String getStokTanim() {
		return stokTanim;
	}

	public void setStokTanim(String stokTanim) {
		this.stokTanim = stokTanim;
	}

}
	
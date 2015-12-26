package org.tutev.web.ws;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.fatura.FaturaWs;

@Service
public class WsServiceHost {

	@Autowired
	private transient BaseDao baseDao;
	
	@PostConstruct
	private void init() {
		
		KisiWs kisiWs =new KisiWs();
		FaturaWs faturaWs =new FaturaWs();
		StokWs stokWs =new StokWs();
		UretimWs uretimWs=new UretimWs();
		
		kisiWs.setBaseDao(baseDao);
		stokWs.setBaseDao(baseDao);
		faturaWs.setBaseDao(baseDao);
		uretimWs.setBaseDao(baseDao);
		
		Endpoint.publish("http://localhost:8082/KisiWs", kisiWs);
		Endpoint.publish("http://localhost:8083/FaturaWs", faturaWs);
		Endpoint.publish("http://localhost:8084/StokWs", stokWs);
		Endpoint.publish("http://localhost:8086/UretimWs", uretimWs);
	}
}

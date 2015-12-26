package org.tutev.web.ws;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

import org.springframework.stereotype.Service;
import org.tutev.web.ws.fatura.FaturaWs;

@Service
public class WsServiceHost {

	@PostConstruct
	private void init() {
		Endpoint.publish("http://localhost:8082/KisiWs", new KisiWs());
		Endpoint.publish("http://localhost:8083/FaturaWs", new FaturaWs());
	}
}

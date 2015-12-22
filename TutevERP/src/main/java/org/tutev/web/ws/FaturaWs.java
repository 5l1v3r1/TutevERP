package org.tutev.web.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.fatura.Fatura;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.response.WsFatura;

//@WebService(name="FaturaWs")
@Service("faturaWs")
public class FaturaWs {

	@Autowired
	private transient BaseDao baseDao;
	
	@WebMethod(operationName="getFaturaById")
	public @WebResult(name="Fatura") WsFatura getFaturaById(@WebParam(name="FaturaId") Long id) {
		WsFatura wsFatura=null;
		if(id!=null){
			wsFatura=new WsFatura();
			Fatura fatura = (Fatura) baseDao.getById(id,Fatura.class);
			if(fatura!=null){
				wsFatura.setFaturaNo(fatura.getFaturaNo());
				wsFatura.setFaturaTarihi(fatura.getFaturaTarihi());
				wsFatura.setId(fatura.getId());
			}
		}
		return wsFatura;
	}
}

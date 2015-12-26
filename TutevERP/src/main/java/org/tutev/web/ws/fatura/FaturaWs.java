package org.tutev.web.ws.fatura;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.tutev.web.erp.entity.fatura.Fatura;
import org.tutev.web.erp.service.BaseDao;

@WebService(name="FaturaWs")
public class FaturaWs {

	private BaseDao baseDao;
	
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
	
	public BaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}

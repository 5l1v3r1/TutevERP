package org.tutev.web.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.response.WsKisi;

@WebService(name="PersonWs")
public class KisiWs{

	private BaseDao baseDao;
	
	@WebMethod(operationName="getPersonById")
	public @WebResult(name="Person") WsKisi getKisiById(@WebParam(name="PersonId") Long id) {
		WsKisi wsKisi=null;
		if(id!=null){
			wsKisi=new WsKisi();
			Kisi kisi = (Kisi) baseDao.getById(id,Kisi.class);
			if(kisi!=null){
				wsKisi.setAd(kisi.getAd());
				wsKisi.setSoyad(kisi.getSoyad());
				wsKisi.setDogumTarihi(kisi.getDogumTarihi());
				wsKisi.setId(kisi.getId());
			}
		}
		return wsKisi;
	}
	
	@WebMethod()
	public List<WsKisi> getKisisByAd(@WebParam(name="PersonName") String ad) {

		return null;
	}
	
	@WebMethod(operationName="getKisisBySoyad")
	public List<WsKisi> getKisisBySoyad(@WebParam(name="PersonSurname") String soyad) {
		return null;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}

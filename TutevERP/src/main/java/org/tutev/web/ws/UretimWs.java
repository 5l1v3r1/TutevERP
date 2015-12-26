package org.tutev.web.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.tutev.web.erp.entity.uretim.Uretim;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.response.WsUretim;

@WebService(name="UretimWs")
public class UretimWs {

	private BaseDao baseDao;
	
	@WebMethod(operationName="getUretimById")
	public @WebResult(name="GnlUretim") WsUretim getUretimById(@WebParam(name="GnlUretimId") Long id) {
		WsUretim wsUretim=null;
		if(id!=null){
			wsUretim=new WsUretim();
			Uretim uretim = (Uretim) baseDao.getById(id,Uretim.class);
			if(uretim!=null){
				wsUretim.setUretimNo(uretim.getUretimNo());
				wsUretim.setMiktar(uretim.getMiktar());
				wsUretim.setTarih(uretim.getTarih());
			}
		}
		return wsUretim;
	}
	
	@WebMethod()
	public List<WsUretim> getUretimByTarih(@WebParam(name="UretimTarih") Date tarih) {

		return null;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}

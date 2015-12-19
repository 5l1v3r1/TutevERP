package org.tutev.web.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.entity.uretim.Uretim;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.response.WsKisi;
import org.tutev.web.ws.response.WsUretim;

@WebService(name="UretimWs")
@Service("uretimWs")
public class UretimWs {

	@Autowired
	private transient BaseDao baseDao;
	
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
	
	
}

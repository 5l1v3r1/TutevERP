package org.tutev.web.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.web.erp.entity.stok.Skart;
import org.tutev.web.erp.service.BaseDao;
import org.tutev.web.ws.response.WsStok;
//http://localhost:8001/Ws/StockWs?wsdl
//@WebService(name="StockWs")
@Service("stokWs")
public class StokWs {

	@Autowired
	private transient BaseDao baseDao;
	
	@WebMethod(operationName="getStockById")
	public @WebResult(name="Stock") WsStok getStockById(@WebParam(name="StockId") Long id) {
		WsStok wsStok=null;
		if(id!=null){
			wsStok=new WsStok();
			Skart skart = (Skart) baseDao.getById(id,Skart.class);
			if(skart!=null){
				wsStok.setStokTanim((skart.getTanim()));
			}
		}
		return wsStok;
	}
	
	@WebMethod()
	public List<WsStok> getStokByTanim(@WebParam(name="StockName") String stokTanim) {

		return null;
	}
	
}

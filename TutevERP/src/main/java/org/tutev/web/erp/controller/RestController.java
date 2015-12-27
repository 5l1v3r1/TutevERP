package org.tutev.web.erp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tutev.web.erp.entity.genel.Kisi;
import org.tutev.web.erp.util.DbUtil;

@Path("/Kisis")
public class RestController {

    @GET
    @Produces("application/json; charset=UTF-8")
    public List<Kisi> getAll(){
    	System.out.println("tr.com.ttemel.controller.RestController.getAll() Call.....");
    	DbUtil dbUtil=new DbUtil();
    	return dbUtil.getKisis();
    }
    
	
	@POST 
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("application/json; charset=UTF-8")	
	public Response add(Kisi kisi) {
		System.out.println(kisi.toString());
		return Response.status(201).build(); 		
	}
 
}

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

//Client Test

 
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
// 
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
// 
///**
// * @author Crunchify.com
// * 
// */
// 
//public class CrunchifyRESTJerseyApacheHTTPClient {
//	public static void main(String[] args) {
// 
//		try {
//			
//			// create HTTP Client
//			HttpClient httpClient = HttpClientBuilder.create().build();
// 
//			// Create new getRequest with below mentioned URL
//			HttpGet getRequest = new HttpGet("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice/");
// 
//			// Add additional header to getRequest which accepts application/xml data
//			getRequest.addHeader("accept", "application/xml");
// 
//			// Execute your request and catch response
//			HttpResponse response = httpClient.execute(getRequest);
// 
//			// Check for HTTP response code: 200 = success
//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
//			}
// 
//			// Get-Capture Complete application/xml body response
//			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
//			String output;
//			System.out.println("============Output:============");
// 
//			// Simply iterate through XML response and show on console.
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
// 
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
// 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}


// POM
//<dependency>
//<groupId>com.sun.jersey</groupId>
//<artifactId>jersey-client</artifactId>
//<version>1.19</version>
//</dependency>
//<dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpcore</artifactId>
//<version>4.4-beta1</version>
//</dependency>
//<dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpclient</artifactId>
//<version>4.4-beta1</version>
//</dependency>

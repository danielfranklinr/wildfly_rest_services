package com.smtt.testing;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@Path("/HelloWorld")
public class HelloWorldService {

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<h1>Hello World2</h1>";
	}

	@GET
	@Path("/voterlist/get")
	public String getVoterList() {
		
		Client client = ClientBuilder.newClient();
		
		Response response = client.target("https:///dkint/api/v1/voterlist").request().get();
		
		String entity = response.readEntity(String.class);
		
		client.close();
		
		

		return "<h1>response:  "+entity+"</h1>";
	}
	
	@GET
	@Path("/voterlist/callback/{code}")
	public String voterListCallback() {
		
		System.out.println("The voter List Callback was invoked");
		

		return "<h1>voter list callback received<h1>";
	}
	

	
}
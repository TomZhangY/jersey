package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mkyong.transaction.TransactionBo;
import com.zhang.software.App;

@Component
@Path("/payment")
public class PaymentService {
//	http://localhost:8080/RESTfulExample/rest/payment/mkyong
	@Autowired
	TransactionBo transactionBo;

	@GET
	@Path("/mkyong")
	public Response savePayment() {

		String result = transactionBo.save();

		 
		WebApplicationContext war = ContextLoader.getCurrentWebApplicationContext();
		App a = (App) war.getBean("app");
		System.out.println(a.getAaa());
		return Response.status(200).entity(result).build();

	}

}
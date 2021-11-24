package com.example.umit.cadirci.homework;

import com.example.umit.cadirci.homework.service.RestService;
import com.example.umit.cadirci.homework.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TransactionReport {

	private Map<String,String> parameters=new HashMap<>();
	private String token="";
	private final String url="https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report";

	@Test
	void contextLoads() {

		parameters.put("fromDate","2015-07-01");
		parameters.put("toDate","2015-10-01");
		parameters.put("merchant","1");
		parameters.put("acquirer","1");

		token=new TokenService().createToken();

		try {
			System.out.println("----------Transaction Report----------");
			System.out.println(new RestService().post(url,parameters,token));
		}catch (IOException e){
			System.out.println("----------Transaction Report Error----------");
			e.printStackTrace();
		}

	}


}

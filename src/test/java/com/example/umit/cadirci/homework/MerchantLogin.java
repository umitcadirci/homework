package com.example.umit.cadirci.homework;

import com.example.umit.cadirci.homework.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MerchantLogin {

	@Test
	void contextLoads() {
		new TokenService().createToken();
	}


}

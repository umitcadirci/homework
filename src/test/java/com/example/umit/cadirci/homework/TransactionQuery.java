package com.example.umit.cadirci.homework;


import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TransactionQuery {
    private Map<String,String> parameters=new HashMap<>();
    private String token="";
    private final String url="https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report";
}

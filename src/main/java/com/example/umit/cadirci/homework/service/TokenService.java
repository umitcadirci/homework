package com.example.umit.cadirci.homework.service;

import com.example.umit.cadirci.homework.dto.TokenResponse;
import com.example.umit.cadirci.homework.dto.UserInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TokenService {

    final String tokenUrl="https://sandbox-reporting.rpdpymnt.com/api/v3/merchant/user/login";
    private Map<String,String> parameters=new HashMap<>();

    public String createToken() {

        try {
            parameters.put("email", UserInfo.email);
            parameters.put("password", UserInfo.password);

            JsonObject jsonObject=new RestService().post(tokenUrl,parameters,null);
            TokenResponse tokenResponse=new Gson().fromJson(jsonObject,TokenResponse.class);

            return tokenResponse.getToken();

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}

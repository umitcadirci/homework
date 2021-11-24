package com.example.umit.cadirci.homework.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class RestService {

    public JsonObject post(String url, Map<String,String> parameters,String token) throws IOException {

        HttpPost postRequest = new HttpPost(url);
        postRequest.setEntity(new StringEntity(new Gson().toJson(parameters), StandardCharsets.UTF_8));
        postRequest.setHeader("Content-Type", "application/json; charset=utf-8");
        if(!Objects.isNull(token) && token.length()>0)
            postRequest.setHeader("Authorization", token);

        return jsonParser(new DefaultHttpClient().execute(postRequest));
    }

    public JsonObject put(String url, Map<String,String> parameters,String token) throws IOException {

        HttpPut putRequset=new HttpPut(url);
        putRequset.setEntity(new StringEntity(new Gson().toJson(parameters), StandardCharsets.UTF_8));
        putRequset.setHeader("Content-Type", "application/json; charset=utf-8");
        if(!Objects.isNull(token) && token.length()>0)
            putRequset.setHeader("Authorization", token);

        return jsonParser(new DefaultHttpClient().execute(putRequset));
    }

    public JsonObject get(String url, Map<String,String> parameters,String token) throws IOException, URISyntaxException {

        HttpGet httpGet=new HttpGet();
        URIBuilder uriBuilder=new URIBuilder(url);
        for (Map.Entry<String, String> send:parameters.entrySet()) {
            uriBuilder.addParameter(send.getKey(),send.getValue());
        }
        httpGet.setURI(uriBuilder.build());
        httpGet.setHeader("Content-Type", "application/json; charset=utf-8");
        if(!Objects.isNull(token) && token.length()>0)
            httpGet.setHeader("Authorization", token);

        return jsonParser(new DefaultHttpClient().execute(httpGet));
    }

    public JsonObject delete(String url, Map<String,String> parameters,String token) throws IOException, URISyntaxException {

        HttpDelete httpDelete=new HttpDelete();
        URIBuilder uriBuilder=new URIBuilder(url);
        for (Map.Entry<String, String> send:parameters.entrySet()) {
            uriBuilder.addParameter(send.getKey(),send.getValue());
        }
        httpDelete.setURI(uriBuilder.build());
        httpDelete.setHeader("Content-Type", "application/json; charset=utf-8");
        if(!Objects.isNull(token) && token.length()>0)
            httpDelete.setHeader("Authorization", token);

        return jsonParser(new DefaultHttpClient().execute(httpDelete));
    }


    private JsonObject jsonParser(HttpResponse response) throws IOException {
        InputStreamReader input=new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8);
        BufferedReader br=new BufferedReader(input);
        StringBuilder convertOut= new StringBuilder();
        String line="";

        while ((line=br.readLine())!=null){
            convertOut.append(line);
        }

        return new JsonParser().parse(convertOut.toString()).getAsJsonObject();
    }
}

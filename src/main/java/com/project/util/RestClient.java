/*
package com.project.util;

import com.project.util.RestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestClient {

    */
/*@Value("${auth.server.baseUrl}")
    private String AUTH_SERVER_BASE_URL;

    @Autowired
    private RestTemplate restTemplate;

    public Object get(RestURL urlDetail, HashMap<String,String> header, HashMap<String,String> param){
        HttpHeaders headers = new HttpHeaders();
        if(header != null && header.size() > 0){
            for(Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                headers.set(key,value);
            }
        }

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        if(param != null && param.size() > 0){
            for(Map.Entry<String, String> entry : param.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                map.set(key,value);
            }
        }

        HttpEntity entity = new HttpEntity(map, headers);
        return restTemplate.exchange(this.AUTH_SERVER_BASE_URL + urlDetail.getUrl(), urlDetail.getRequestMethod(),entity, Integer.class).getBody();
    }*//*

}
*/

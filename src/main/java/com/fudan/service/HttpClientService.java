package com.fudan.service;

import com.fudan.util.UrlBuilder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


@Service
public class HttpClientService {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JSONObject getOpenId(String url) {
        try {
            URL connectUrl = new URL(url);
            URLConnection connection = connectUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
                builder.append(line);
            reader.close();
            return JSONObject.fromObject(builder.toString());
        } catch (IOException e) {
            return null;
        }
    }

    public JSONObject getToken(String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(UrlBuilder.urlForToken(), httpEntity, String.class);
        return JSONObject.fromObject(responseEntity.getBody());
    }

}
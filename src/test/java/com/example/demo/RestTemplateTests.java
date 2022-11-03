package com.example.demo;

import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTests {
    
    @Test
    public void getTest() {
        RestTemplate template = new RestTemplate();
        String apiUrl = "https://api.plos.org/search?q=title:hope";
        Map res = template.getForObject(apiUrl, Map.class);
        System.out.println(res);
    }

    @Test
    public void postTest() {
        RestTemplate template = new RestTemplate();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("q", "title:test");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity formEntity = new HttpEntity<>(parameters, headers);

        String apiUrl = "https://api.plos.org/search";
        Map res = template.postForObject(apiUrl, formEntity, Map.class);
        System.out.println(res);
    }

}

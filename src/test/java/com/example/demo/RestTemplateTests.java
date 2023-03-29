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

    @Test 
    public void fileTest2() {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource("path/to/file"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            "http://example.com/upload",
            HttpMethod.POST,
            requestEntity,
            String.class);

        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody());
    }

}

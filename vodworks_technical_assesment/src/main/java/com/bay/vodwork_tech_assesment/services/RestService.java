package com.bay.vodwork_tech_assesment.services;

import org.json.JSONException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class RestService {

    private RestTemplate restTemplate;
    private static Log log = LogFactory.getLog(RestService.class);

    //Spring Boot does not provide any single auto-configured RestTemplate bean. It does, however,
    // auto-configure a RestTemplateBuilder, which can be used to create RestTemplate instances when needed.
    public RestService() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder.build();
    }

    public String readJsonFile(String jsonFileUrl) throws JSONException {

        log.info("Going to Download Assets JSON File from Url: " + jsonFileUrl);

        String jsonFileStr = "";

        jsonFileStr = restTemplate.getForObject(jsonFileUrl, String.class);

        log.info("Assets JSON file Downloaded Successfully!");

        return jsonFileStr;
    }
}
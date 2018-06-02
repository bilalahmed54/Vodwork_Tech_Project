package com.bay.vodwork_tech_assesment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.bay.vodwork_tech_assesment.services.RestService;
import com.bay.vodwork_tech_assesment.services.AssetManagement;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VodworkTechAssesmentApplication {

    //Loading JSON file URL from properties file
    @Value("${app.VOD_ASSET_JSON_FILE_PATH}")
    String jsonFileUrl;

    private static Log log = LogFactory.getLog(VodworkTechAssesmentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VodworkTechAssesmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {

        return args -> {
            log.info("Initializing Vodwork Assets Application!");

            RestService restService = new RestService();
            String jsonFileStr = restService.readJsonFile(jsonFileUrl);
            AssetManagement.processAssets(jsonFileStr);

            log.info("Application Initialized Successfully!");
        };
    }
}
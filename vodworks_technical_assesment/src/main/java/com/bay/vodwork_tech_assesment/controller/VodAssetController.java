package com.bay.vodwork_tech_assesment.controller;

import java.util.List;
import com.bay.vodwork_tech_assesment.domain.VodAsset;
import org.apache.commons.logging.Log;
import com.bay.vodwork_tech_assesment.services.VodAssetContainer;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class VodAssetController {

    private static Log log = LogFactory.getLog(VodAssetController.class);

    @RequestMapping("/test")
    public String test() {
        log.info("Got Request to Fetch Vod Assets List.");
        return "Hello World!";
    }

    @RequestMapping("/assets/index")
    public List<VodAsset> index() {
        log.info("Got Request to Fetch Vod Assets List.");
        log.info("Total Vod Assets Found: " + VodAssetContainer.getInstance().totalVodAssets());
        return VodAssetContainer.getInstance().getVodAssets();
    }
}
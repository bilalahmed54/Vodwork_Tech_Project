package com.bay.vodwork_tech_assesment.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.bay.vodwork_tech_assesment.domain.VodAsset;

public class AssetManagement {

    private static Log log = LogFactory.getLog(AssetManagement.class);

    public static void processAssets(String jsonFileStr) throws JSONException {

        log.info("Going to Parse Vodwork Assets JSON file.");

        JSONArray jsonArray = new JSONArray(jsonFileStr);

        System.out.println("Total Objects Fetched from JSON File: " + jsonArray.length());

        for (int index = 0; index < jsonArray.length(); index++) {

            VodAsset vodAsset = new VodAsset();

            try {

                JSONObject jsonObject = jsonArray.getJSONObject(index);

                try {

                    vodAsset.setId(jsonObject.getString("id"));
                    vodAsset.setUrl(jsonObject.getString("url"));
                    vodAsset.setCert(jsonObject.getString("cert"));
                    vodAsset.setYear(jsonObject.getString("year"));
                    vodAsset.setRating(jsonObject.getString("rating"));
                    vodAsset.setAssetClass(jsonObject.getString("class"));
                    vodAsset.setDuration(jsonObject.getString("duration"));
                    vodAsset.setHeadline(jsonObject.getString("headline"));

                    JSONArray cardImages = jsonObject.getJSONArray("cardImages");

                    System.out.println("**********************Extracting Card Images**********************");

                    for (int cardImageIndex = 0; cardImageIndex < cardImages.length(); cardImageIndex++) {
                        JSONObject jsonCardImageObject = cardImages.getJSONObject(cardImageIndex);
                        vodAsset.addCardImagesUrl(jsonCardImageObject.getString("url"));
                        System.out.println(jsonCardImageObject.getString("url"));
                    }
                } catch (JSONException ex) {
                    log.info("NOT_FOUND:: No Key Card Image Found at Object: " + index);
                }

                try {
                    JSONArray keyArtImages = jsonObject.getJSONArray("keyArtImages");

                    System.out.println("**********************Extracting Key Art Images**********************");

                    for (int keyArtImageIndex = 0; keyArtImageIndex < keyArtImages.length(); keyArtImageIndex++) {
                        JSONObject jsonKeyArtImageObject = keyArtImages.getJSONObject(keyArtImageIndex);
                        vodAsset.addKeyArtImagesUrl(jsonKeyArtImageObject.getString("url"));
                        System.out.println(jsonKeyArtImageObject.getString("url"));
                    }

                } catch (JSONException ex) {
                    log.info("NOT_FOUND:: No Key Art Image Found at Object: " + index);
                }

                try {

                    JSONArray videoes = jsonObject.getJSONArray("videos");

                    System.out.println("**********************Extracting Video URLs**********************");

                    for (int videoIndex = 0; videoIndex < videoes.length(); videoIndex++) {
                        JSONObject jsonVideoObject = videoes.getJSONObject(videoIndex);
                        vodAsset.addVideoUrl(jsonVideoObject.getString("url"));
                        System.out.println(jsonVideoObject.getString("url"));
                    }
                } catch (JSONException ex) {
                    log.info("NOT_FOUND:: No Video URL Found at Object: " + index);
                }

                System.out.println("=======================================================");

            } catch (Exception ex) {
                log.info("ERROR:: Error Occurred while Parsing Object at Index: " + index);
            }

            VodAssetContainer.getInstance().addVodAsset(vodAsset);
        }

        log.info("Total Items Added in the Container: " + VodAssetContainer.getInstance().totalVodAssets());
    }
}
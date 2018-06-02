package com.bay.vodwork_tech_assesment.domain;

import java.util.List;
import java.util.ArrayList;

public class VodAsset {

    String id;
    String url;
    String cert;
    String year;
    String rating;
    String duration;
    String headline;
    String assetClass;

    List<String> videoUrls = new ArrayList<>();
    List<String> cardImagesUrls = new ArrayList<>();
    List<String> keyArtImagesUrls = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public List<String> getVideoUrls() {
        return videoUrls;
    }

    public void setVideoUrls(List<String> videoUrls) {
        this.videoUrls = videoUrls;
    }

    public void addVideoUrl(String videoUrl) {
        this.videoUrls.add(videoUrl);
    }

    public List<String> getCardImagesUrls() {
        return cardImagesUrls;
    }

    public void setCardImagesUrls(List<String> cardImagesUrls) {
        this.cardImagesUrls = cardImagesUrls;
    }

    public void addCardImagesUrl(String cardImagesUrl) {
        this.cardImagesUrls.add(cardImagesUrl);
    }

    public List<String> getKeyArtImagesUrls() {
        return keyArtImagesUrls;
    }

    public void setKeyArtImagesUrls(List<String> keyArtImagesUrls) {
        this.keyArtImagesUrls = keyArtImagesUrls;
    }

    public void addKeyArtImagesUrl(String keyArtImagesUrl) {
        this.keyArtImagesUrls.add(keyArtImagesUrl);
    }
}
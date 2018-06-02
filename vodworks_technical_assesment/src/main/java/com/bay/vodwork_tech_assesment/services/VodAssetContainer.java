package com.bay.vodwork_tech_assesment.services;

import java.util.List;
import java.util.ArrayList;
import com.bay.vodwork_tech_assesment.domain.VodAsset;

//Implemented Singleton Pattern
public class VodAssetContainer {

    private List<VodAsset> vodAssetsList = new ArrayList<>();
    private static VodAssetContainer vodAssetContainer = null;

    private VodAssetContainer() {
    }

    public static VodAssetContainer getInstance() {

        if (vodAssetContainer == null) {
            vodAssetContainer = new VodAssetContainer();
        }

        return vodAssetContainer;
    }

    public void addVodAsset(VodAsset vodAsset) {
        vodAssetsList.add(vodAsset);
    }

    public List<VodAsset> getVodAssets() {
        return vodAssetsList;
    }

    public int totalVodAssets() {
        return vodAssetsList.size();
    }
}
package com.empire_of_science.joao.coloreaters2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by João on 03/10/2016.
 * Contains all the necessary code about the ads.
 */
 class AdControl {

    /**
     * The constructor sets the AdView.
     * @param activity Associated GameActivity.
     */
    public static void setAdd(GameActivity activity){
        AdView mAdView = (AdView) activity.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}

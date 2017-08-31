package com.empire_of_science.joao.coloreaters2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by João on 03/10/2016.
 * Copyright João Afonso.
 * Contains all the necessary code about the ads.
 */
 class AdControl {

    /**
     * The constructor sets the AdView.
     * @param activity Associated Activity_GameActivity.
     */
    public static void setAdd(Activity_GameActivity activity){
        AdView mAdView = (AdView) activity.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}

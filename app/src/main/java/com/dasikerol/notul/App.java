package com.dasikerol.notul;

import android.app.Application;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

public class App extends Application {

    private static final String AF_DEV_KEY = "nMy29SFSZdtx9K8iKXArUQ";
    static String appsFlyerId;

    public static String af_data;

    SplashActivity splashScreen;


    @Override
    public void onCreate(){
        super.onCreate();
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {


            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                splashScreen = new SplashActivity();
                StringBuilder params = new StringBuilder("&");
                for (String attrName : conversionData.keySet()) {
                    params.append(attrName).append("=").append(conversionData.get(attrName)).append("&");
                }
                af_data = params.toString().replace(" ", "_");
                splashScreen.afData(af_data);
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d("LOG_TAG", "error getting conversion data: " + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
                for (String attrName : attributionData.keySet()) {
                    Log.d("LOG_TAG", "attribute: " + attrName + " = " + attributionData.get(attrName));
                }

            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d("LOG_TAG", "error onAttributionFailure : " + errorMessage);
            }
        };

        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionListener, this);

        AppsFlyerLib.getInstance().startTracking(this);

        appsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(this);

    }
    static public String getAppsFlyerId() {

        return appsFlyerId;
    }


}
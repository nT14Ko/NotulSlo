package com.dasikerol.notul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onesignal.OneSignal;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class SplashActivity extends AppCompatActivity {
    private Timer timer;
    private TimerTask timerTask;

    private SharedPreferences sharedPreferences;
    private String param = "";
    private String response = "";
    private String country = "";
    private String insurance = "";

    private String model;

    private int checker;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        setContentView(R.layout.activity_splash);
        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        checker = sharedPreferences.getInt("checker", 0);
        String installID = sharedPreferences.getString("installID", null);
        if (installID == null) {
            installID = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("installID", installID).apply();
        }


        final FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.keys);



        String gamar = sharedPreferences.getString("param", "");
        assert gamar != null;
        if (!gamar.equals("")) {
            Intent intent = new Intent(this, Privacy.class);
            startActivity(intent);
            finish();
        } else {
            if (isNetworkConnected()) {
                mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            model = mFirebaseRemoteConfig.getString("url");
                            getInfo(model);
                        }
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, LobbyActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }
        }
    }

    public void afData(String afdata){
        Log.d("main", afdata);
        getInfo(afdata);
    }

    private void getInfo(final String test) {

        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        param = sharedPreferences.getString("param", "");
        final String installID = sharedPreferences.getString("installID", null);

        sharedPreferences.edit().putInt("checker", 1).apply();

        assert param != null;
        if (param.equals("") || param.length() < 7) {
            assert installID != null;
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    param = test;

                    assert country != null;

                    checker = checker + 1;

                    try {
                        String test = App.getAppsFlyerId();
                        final String mrep = param + "&deviceid=" + test;
                        Log.d("Main", mrep);


                        if ((param != null && !param.equals(""))) {
                            timer = new Timer();
                            timerTask = new TimerTask() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(SplashActivity.this, Privacy.class);
                                    sharedPreferences.edit().putString("param", mrep).apply();
                                    startActivity(intent);
                                    finish();
                                }
                            };
                            timer.schedule(timerTask, 1500);
                        } else {
                            Intent intent = new Intent(SplashActivity.this, LobbyActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } catch(NullPointerException e){
                        runOnUiThread(new Runnable(){
                            public void run(){
                                Intent intent = new Intent(SplashActivity.this, LobbyActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }
            };
            timer.schedule(timerTask, 2000);
        }
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null;
    }
}
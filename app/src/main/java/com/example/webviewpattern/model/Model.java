package com.example.webviewpattern.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.WebView;


import com.example.webviewpattern.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Дом on 31.01.2018.
 */

@Module
public class Model implements IModel {

    private static String htmlDocument = "";


    Context context;

    public Model(Context context) {
        this.context = context;
    }

    @Provides
    @NonNull
    @Singleton
    public Model provideModel(Context context){
        return new Model(context);
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Override
    public String getUrl() {
        return context.getString(R.string.game_link);
    }

    @Override
    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}

package com.example.webviewpattern.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import com.example.webviewpattern.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

/**
 * Created by Дом on 31.01.2018.
 */


public class Model implements IModel {

    Context context;

    @Inject
    public Model(Context context) {
        this.context = context;
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

    @Override
    public boolean getServerResponse() {
        String serverCheckResponse = "";

        try {
            serverCheckResponse = getNetworkStringResponse(context.getString
                    (R.string.server_link));
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean result = false;

        //Log.d("MODEL SERVER RESPONSE", serverCheckResponse);

        if (serverCheckResponse.equals(SERVER_RESPONSE_POSITIVE)) result = true;

        else if (serverCheckResponse.equals(SERVER_RESPONSE_NEGATIVE)) result = false;

        return result;
    }

    @Override
    public String getServerLink() {
        String serverLink = "";

        try {
            serverLink = getNetworkStringResponse(context.getString
                    (R.string.server_addwert_response_link));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Log.d("MODEL SERVER LINK: ", serverLink);
        return serverLink;
    }

    private String getNetworkStringResponse(String link) throws IOException {

        URL remoteUrl = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) remoteUrl.openConnection();
        InputStream pageStream = connection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(pageStream));

        return reader.readLine();
    }
}

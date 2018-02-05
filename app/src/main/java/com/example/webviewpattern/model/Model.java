package com.example.webviewpattern.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



import com.example.webviewpattern.R;
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
}

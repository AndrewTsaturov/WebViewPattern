package com.example.webviewpattern.view;

import android.webkit.WebView;

/**
 * Created by Дом on 31.01.2018.
 */

public interface IView {
    void showLoading();

    void hideLoading();

    void showGame(String gameUrl);

    void showLackOfNewtworkWarning();

    void showNetworkSettings();

    void stopView();
}

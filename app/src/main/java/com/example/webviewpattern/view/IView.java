package com.example.webviewpattern.view;


/**
 * Created by Дом on 31.01.2018.
 */

public interface IView {
    void showLoading();

    void hideLoading();

    void showGame(String gameUrl);

    void showLackOfNetworkWarning();

    void showNetworkSettings();

    void stopView();
}

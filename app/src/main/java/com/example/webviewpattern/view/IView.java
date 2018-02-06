package com.example.webviewpattern.view;



public interface IView {
    void showLoading();

    void hideLoading();

    void showPage(String gameUrl);

    void showLackOfNetworkWarning();

    void showNetworkSettings();

    void stopView();
}

package com.example.webviewpattern.presenter;

import android.os.Handler;

import com.example.webviewpattern.model.IModel;
import com.example.webviewpattern.view.IView;

import javax.inject.Inject;


/**
 * Created by Дом on 31.01.2018.
 */

public class AppPresenter implements IAppPresenter {
    private static boolean isSettingsChanged;

    @Inject
    IModel model;

    @Inject
    IView view;


    @Inject
    public AppPresenter(IView view) {
        this.view = view;
    }

    @Override
    public void onViewInit() {
        start();
    }

    @Override
    public void onPositiveWarningClick() {
        setSettingChanged(true);
        view.showNetworkSettings();
    }

    @Override
    public void onNegativeWarningClick() {
        view.stopView();
    }

    @Override
    public void setSettingChanged(boolean isSettingsChanged) {
        this.isSettingsChanged = isSettingsChanged;
    }

    @Override
    public boolean isSettingsChanged() {
        return isSettingsChanged;
    }

    @Override
    public void gameIsLoaded() {
        view.hideLoading();
    }

    private void start() {
        view.showLoading();

        if (model.isConnected())
            executeLoading();

        else view.showLackOfNetworkWarning();
    }

    private void loadPage(String pageUrl) {
        view.showPage(pageUrl);
        view.hideLoading();
    }

    private void executeLoading() {
        Handler handler = new Handler();

        Thread thread = new Thread() {

            @Override
            public void run() {

                if (model.getServerResponse()) {
                    handler.post(() -> loadPage(model.getUrl()));

                } else {
                    String serverLink = model.getServerLink();

                    handler.post(() -> loadPage(serverLink));
                }
            }
        };

        thread.start();
    }

}

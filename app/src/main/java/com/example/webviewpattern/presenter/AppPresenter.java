package com.example.webviewpattern.presenter;
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

    private void loadGame() {
        view.showGame(model.getUrl());
    }

    private void start() {
        view.showLoading();
        if(model.isConnected())
            view.showGame(model.getUrl());

        else view.showLackOfNetworkWarning();
    }


}

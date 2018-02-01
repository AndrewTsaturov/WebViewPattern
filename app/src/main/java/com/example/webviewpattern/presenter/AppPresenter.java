package com.example.webviewpattern.presenter;


import android.os.Handler;

import com.example.webviewpattern.WebViewApp;
import com.example.webviewpattern.model.Model;
import com.example.webviewpattern.view.IView;

import javax.inject.Inject;



/**
 * Created by Дом on 31.01.2018.
 */

public class AppPresenter implements IAppPresenter {
    private static boolean isSettingsChanged;

    @Inject
    Model model;

    private IView view;


    public AppPresenter(IView view) {
        this.view = view;


        WebViewApp.getInstance().getModelComponent().inject(this);
    }

    @Override
    public void onViewInit() {
        start();
      }

    @Override
    public void onBackButtonPressed() {
       view.stopView();
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

    private void loadGame() {
        view.showGame(model.getUrl());
    }

    private void start() {
        view.showLoading();

        Handler handler = new Handler();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    int timer = 0;
                    while (timer < LOADING_TIMER){
                        handler.post(()-> {
                            if (model.isConnected()) {loadGame();
                            setSettingChanged(false);
                            }
                        });

                        sleep(LOADING_CYCLE_DELAY);
                        timer = timer + (int) LOADING_CYCLE_DELAY;
                    }

                    handler.post(() -> {
                        if(model.isConnected())
                        view.hideLoading();

                        else view.showLackOfNewtworkWarning();
                    });
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }


}

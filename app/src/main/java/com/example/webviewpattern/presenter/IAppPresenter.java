package com.example.webviewpattern.presenter;

/**
 * Created by Дом on 31.01.2018.
 */

public interface IAppPresenter {
    long LOADING_CYCLE_DELAY = 100;
    int LOADING_TIMER = 4000;

    void onViewInit();
    void onBackButtonPressed();

    void onPositiveWarningClick();
    void onNegativeWarningClick();

    void setSettingChanged(boolean isSettingsChanged);
    boolean isSettingsChanged();
}

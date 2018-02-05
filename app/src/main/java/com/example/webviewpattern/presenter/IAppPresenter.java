package com.example.webviewpattern.presenter;

/**
 * Created by Дом on 31.01.2018.
 */

public interface IAppPresenter {
    void onViewInit();

    void onPositiveWarningClick();
    void onNegativeWarningClick();

    void setSettingChanged(boolean isSettingsChanged);
    boolean isSettingsChanged();

    void gameIsLoaded();
}

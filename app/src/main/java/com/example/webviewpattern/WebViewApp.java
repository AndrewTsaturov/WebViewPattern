package com.example.webviewpattern;


import com.example.webviewpattern.Dagger2Utils.AppModule;
import com.example.webviewpattern.Dagger2Utils.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by Дом on 31.01.2018.
 */

public class WebViewApp extends DaggerApplication {

    @Inject
    public WebViewApp() {
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().
                appModule(new AppModule(this)).build();
    }
}
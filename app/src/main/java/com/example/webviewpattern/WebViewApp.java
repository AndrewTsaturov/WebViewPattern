package com.example.webviewpattern;

import android.app.Application;

import com.example.webviewpattern.Dagger2Utils.DaggerModelComponent;
import com.example.webviewpattern.Dagger2Utils.ModelComponent;
import com.example.webviewpattern.model.Model;

/**
 * Created by Дом on 31.01.2018.
 */

public class WebViewApp extends Application {

    protected static WebViewApp instance;

    public static WebViewApp getInstance(){
        return instance;
    }

    private ModelComponent modelComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        modelComponent = buildModel();
    }

    private ModelComponent buildModel() {
        return DaggerModelComponent.builder()
                .model(new Model(this))
                .build();
    }

    public ModelComponent getModelComponent() {
        return modelComponent;
    }

    public void clearModelComponent(){
        modelComponent = null;
    }

}

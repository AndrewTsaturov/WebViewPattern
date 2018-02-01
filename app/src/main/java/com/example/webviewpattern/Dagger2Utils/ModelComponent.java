package com.example.webviewpattern.Dagger2Utils;

import com.example.webviewpattern.model.Model;
import com.example.webviewpattern.presenter.AppPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Дом on 01.02.2018.
 */
@Component(modules = Model.class)
@Singleton
public interface ModelComponent {

    void inject (AppPresenter appPresenter);
}

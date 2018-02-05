package com.example.webviewpattern.Dagger2Utils;

import com.example.webviewpattern.presenter.AppPresenter;
import com.example.webviewpattern.presenter.IAppPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Дом on 06.02.2018.
 */
@Module
public abstract class PresenterModule {
    @Binds
    abstract IAppPresenter bindAppResenter(AppPresenter presenter);
}

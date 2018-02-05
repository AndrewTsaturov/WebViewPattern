package com.example.webviewpattern.Dagger2Utils;


import com.example.webviewpattern.view.IView;
import com.example.webviewpattern.view.MainActivity;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Дом on 05.02.2018.
 */
@Module
public abstract class MainActivityModule {

    @Binds
    abstract IView bindView(MainActivity mainActivity);
}

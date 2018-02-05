package com.example.webviewpattern.Dagger2Utils;

import com.example.webviewpattern.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Дом on 05.02.2018.
 */

@Module
public abstract class ActivityBulder {
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}

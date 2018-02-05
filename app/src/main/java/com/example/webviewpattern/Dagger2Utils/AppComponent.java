package com.example.webviewpattern.Dagger2Utils;

import com.example.webviewpattern.WebViewApp;


import javax.inject.Singleton;


import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by Дом on 01.02.2018.
 */
@Component(modules = {AppModule.class,
        ActivityBulder.class,
        AndroidInjectionModule.class,
        ModelModule.class,
        PresenterModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<WebViewApp>{

    void inject(WebViewApp webViewApp);
}

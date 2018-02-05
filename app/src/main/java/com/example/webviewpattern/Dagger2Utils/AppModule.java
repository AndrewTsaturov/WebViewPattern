package com.example.webviewpattern.Dagger2Utils;

import android.content.Context;

import com.example.webviewpattern.model.Model;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Дом on 05.02.2018.
 */

@Module
public class AppModule {

    Context context;

    @Inject
    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    Model provideModel(Context context){
        return new Model(context);
    }
}

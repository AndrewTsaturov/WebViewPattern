package com.example.webviewpattern.Dagger2Utils;

import com.example.webviewpattern.model.IModel;
import com.example.webviewpattern.model.Model;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Дом on 06.02.2018.
 */

@Module
public abstract class ModelModule {

    @Binds
    abstract IModel bindModel(Model model);
}

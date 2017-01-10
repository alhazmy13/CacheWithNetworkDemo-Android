package net.alhazmy13.cachewithnetworkdemo.app;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alhazmy13 on 11/9/16.
 */


@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {



}
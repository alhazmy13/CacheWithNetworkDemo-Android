package net.alhazmy13.cachewithnetworkdemo.app;

import android.app.Application;

import net.alhazmy13.cachewithnetworkdemo.Utility.UrlHelper;

/**
 * Created by alhazmy13 on 1/9/17.
 */

public class App extends Application {
    private AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .netModule(new NetModule(UrlHelper.getBaseUrl()))
                .build();


    }
}

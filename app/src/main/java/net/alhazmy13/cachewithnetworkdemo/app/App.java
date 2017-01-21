package net.alhazmy13.cachewithnetworkdemo.app;

import android.app.Application;

import net.alhazmy13.cachewithnetworkdemo.utility.UrlHelper;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.AppModule;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.DaggerNetComponent;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.ImplModule;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.NetComponent;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.NetModule;
import net.alhazmy13.cachewithnetworkdemo.utility.dagger.ServicesModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by alhazmy13 on 1/9/17.
 */

public class App extends Application {
    private NetComponent mNetComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initRealmConfiguration();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(UrlHelper.getBaseUrl()))
                .servicesModule(new ServicesModule())
                .implModule(new ImplModule())
                .build();

    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


    public NetComponent getAppComponent() {
        return mNetComponent;
    }
}

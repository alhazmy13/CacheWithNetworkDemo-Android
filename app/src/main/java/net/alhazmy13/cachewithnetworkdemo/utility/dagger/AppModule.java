package net.alhazmy13.cachewithnetworkdemo.utility.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Alhazmy13 on 11/9/16.
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }


}

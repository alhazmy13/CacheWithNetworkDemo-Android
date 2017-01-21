package net.alhazmy13.cachewithnetworkdemo.utility.dagger;

import android.app.Application;

import net.alhazmy13.cachewithnetworkdemo.posts.data.PostService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRealmImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitImpl;
import net.alhazmy13.cachewithnetworkdemo.utility.Constant;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alhazmy13 on 1/21/17.
 */

@Module
public class ServicesModule {

    @Provides
    @Named(Constant.Named.OnlyNetwork)
    PostService providesPostService(PostRetrofitImpl postRetrofitImpl) {
        return new PostService(postRetrofitImpl);
    }


    @Provides
    @Named(Constant.Named.NetworkWithRealmCaching)
    PostService providesPostServiceWithRealmImpl(PostRetrofitImpl postRetrofitImpl, PostRealmImpl postRealm, Application application) {
        return new PostService(postRetrofitImpl, postRealm, application);
    }
}

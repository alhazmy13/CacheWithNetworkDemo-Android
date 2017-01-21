package net.alhazmy13.cachewithnetworkdemo.utility.dagger;

import net.alhazmy13.cachewithnetworkdemo.posts.data.PostService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRealmImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by alhazmy13 on 1/21/17.
 */

@Module
public class ImplModule {


    @Provides
    @Singleton
    PostRealmImpl providesPostRealmImpl() {
        return new PostRealmImpl();
    }

    @Provides
    @Singleton
    PostRetrofitImpl providesPostRetrofitImpl(Retrofit retrofit) {
        return new PostRetrofitImpl(retrofit.create(PostRetrofitService.class));
    }
}

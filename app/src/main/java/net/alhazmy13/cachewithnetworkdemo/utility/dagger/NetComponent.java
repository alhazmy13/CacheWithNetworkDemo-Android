package net.alhazmy13.cachewithnetworkdemo.utility.dagger;

import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.presentation.PostActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alhazmy13 on 11/9/16.
 */


@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {


    void inject(PostActivity postActivity);

    void inject(PostRetrofitImpl postRetrofit);
}
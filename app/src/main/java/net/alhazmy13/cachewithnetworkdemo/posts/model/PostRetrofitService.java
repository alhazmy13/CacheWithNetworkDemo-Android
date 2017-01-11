package net.alhazmy13.cachewithnetworkdemo.posts.model;


import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;


public interface PostRetrofitService {

    @GET("/posts")
    Observable<Response<List<Post>>> fetchPosts();

}



package net.alhazmy13.cachewithnetworkdemo.posts.data;


import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

import rx.Observable;

public interface PostRepository {


    Observable<List<Post>> fetchPosts();

}

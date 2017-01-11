package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import android.util.Log;
import android.widget.Toast;

import net.alhazmy13.cachewithnetworkdemo.posts.data.PostService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alhazmy13 on 1/10/17.
 */


class PostPresenter {
    private List<Post> postList = new ArrayList<>();
    private PostView mView;
    private PostService mService;


    @Inject
    public PostPresenter() {
    }

    void init(PostView view, PostService service) {
        this.mView = view;
        this.mService = service;
    }

    void fetchAllPosts() {
        mView.showProgressDialog();
        mService.fetchPosts()
                .subscribe(new Subscriber<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.hideProgressDialog();
                        mView.showToast(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.hideProgressDialog();
                        postList.clear();
                        postList.addAll(posts);
                        mView.notifyPostChanged();

                    }
                });
    }

    List<Post> getPostList() {
        return postList;
    }
}

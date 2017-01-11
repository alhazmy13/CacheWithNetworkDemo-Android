package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

import javax.inject.Singleton;

/**
 * Created by alhazmy13 on 1/10/17.
 */

 interface PostView {


    void showToast(String message);

    void notifyPostChanged();

    void showProgressDialog();

    void hideProgressDialog();
}

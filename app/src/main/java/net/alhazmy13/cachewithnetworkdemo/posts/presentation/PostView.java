package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

/**
 * Created by alhazmy13 on 1/10/17.
 */

interface PostView {


    void showToast(String message);

    void notifyPostChanged();

    void showProgressDialog();

    void hideProgressDialog();
}

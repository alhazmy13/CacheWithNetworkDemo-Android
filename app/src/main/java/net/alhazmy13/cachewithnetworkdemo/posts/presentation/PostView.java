package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alhazmy13 on 1/10/17.
 */

interface PostView {


    void showToast(String message);

    void notifyPostChanged(List<Post> list);

    void showProgressDialog();

    void hideProgressDialog();
}

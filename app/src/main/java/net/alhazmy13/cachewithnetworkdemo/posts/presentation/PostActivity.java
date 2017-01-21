package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.alhazmy13.cachewithnetworkdemo.R;
import net.alhazmy13.cachewithnetworkdemo.app.App;
import net.alhazmy13.cachewithnetworkdemo.app.BaseActivity;
import net.alhazmy13.cachewithnetworkdemo.posts.data.PostService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRealmImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;
import net.alhazmy13.cachewithnetworkdemo.posts.presentation.adapter.PostAdapter;
import net.alhazmy13.cachewithnetworkdemo.utility.Constant;
import net.alhazmy13.gota.Gota;
import net.alhazmy13.gota.GotaResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class PostActivity extends BaseActivity implements PostView, PostAdapter.OnListFragmentInteractionListener, Gota.OnRequestPermissionsBack {
    private static final String TAG = "PostActivity";

    @Inject
    PostPresenter mPresenter;
    private PostAdapter mAdapter;
    @BindView(R.id.list)
    RecyclerView recyclerView;
    @Inject @Named(Constant.Named.NetworkWithRealmCaching)
    PostService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void checkPermission() {
        new Gota.Builder(this)
                .withPermissions(Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)
                .setListener(this)
                .check();
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        ((App) getApplicationContext()).getAppComponent().inject(this);
        mAdapter = new PostAdapter(mPresenter.getPostList(), this);
        recyclerView.setAdapter(mAdapter);
        mPresenter.init(this, mService);
        checkPermission();

    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(int position) {
        Log.d(TAG, "onListFragmentInteraction() called with: position = [" + position + "]");
    }

    @Override
    public void onRequestBack(int requestId, @NonNull GotaResponse gotaResponse) {
        if (gotaResponse.isAllGranted()) {
            mPresenter.fetchAllPosts();
        }
    }


    @Override
    public void notifyPostChanged(List<Post> list) {
        mAdapter.updateList(list);
    }


}

package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
import net.alhazmy13.gota.Gota;
import net.alhazmy13.gota.GotaResponse;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.Retrofit;

public class PostActivity extends BaseActivity implements PostView, PostAdapter.OnListFragmentInteractionListener, Gota.OnRequestPermissionsBack {
    private static final String TAG = "PostActivity";

    @Inject
    PostPresenter mPresenter;
    @Inject
    Retrofit mRetrofit;
    private PostAdapter mAdapter;
    @BindView(R.id.list)
    RecyclerView recyclerView;
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
        mPresenter.init(this, new PostService(new PostRetrofitImpl(mRetrofit.create(PostRetrofitService.class)),new PostRealmImpl(),this));
        recyclerView.setAdapter(mAdapter);
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
    public void notifyPostChanged() {
        mAdapter.notifyDataSetChanged();
        Realm realm = Realm.getDefaultInstance();
        List<Post> allSavedCountries = realm.where(Post.class).findAll();
        Log.d(TAG, "notifyPostChanged: "+allSavedCountries.size());
       // Post specificCountry = realm.where(Country.class).equalTo("alpha2Code", "AT").findFirst();
    }
}

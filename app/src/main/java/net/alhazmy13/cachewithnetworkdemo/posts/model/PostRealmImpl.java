package net.alhazmy13.cachewithnetworkdemo.posts.model;


import android.content.Context;

import net.alhazmy13.cachewithnetworkdemo.posts.data.PostRepository;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;
import net.alhazmy13.cachewithnetworkdemo.utility.NetworkParser;
import net.alhazmy13.cachewithnetworkdemo.utility.Utility;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class PostRealmImpl implements PostRepository {
    private static final String TAG = "UserRetrofitImpl";
    private final Context mContext;

    public PostRealmImpl(Context context) {
        this.mContext = context;
    }



    @Override
    public Observable<List<Post>> fetchPosts() {
        Realm.init(mContext);
        final Realm realm = Realm.getDefaultInstance();
        return realm.where(Post.class).findAll().asObservable()
                .map(new Func1<RealmResults<Post>, List<Post>>() {
                    @Override
                    public List<Post> call(RealmResults<Post> results) {
                        return realm.copyFromRealm(results);
                    }
                });


    }
}



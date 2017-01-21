package net.alhazmy13.cachewithnetworkdemo.posts.model;


import net.alhazmy13.cachewithnetworkdemo.posts.data.PostRepository;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Func1;

public class PostRealmImpl implements PostRepository {
    private static final String TAG = "UserRetrofitImpl";
    private Realm mRealm;

    @Inject
    public PostRealmImpl() {
        this.mRealm = Realm.getDefaultInstance();
    }


    @Override
    public Observable<List<Post>> fetchPosts() {
        return mRealm.where(Post.class).findAll().asObservable()
                .map(new Func1<RealmResults<Post>, List<Post>>() {
                    @Override
                    public List<Post> call(RealmResults<Post> results) {
                        return mRealm.copyFromRealm(results);
                    }
                });


    }
}



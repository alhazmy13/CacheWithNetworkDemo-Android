package net.alhazmy13.cachewithnetworkdemo.posts.data;

import android.content.Context;

import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;
import net.alhazmy13.cachewithnetworkdemo.utility.Utility;

import java.util.List;
import rx.Observable;

public class PostService implements PostRepository {

    private Context mContext;
    private PostRepository mRepo;
    private PostRepository mOfflineRepo;
    public PostService(PostRepository repo) {
        this.mRepo = repo;
    }

    public PostService(PostRepository repo, PostRepository offlineRepo, Context context) {
        this.mRepo = repo;
        this.mOfflineRepo = offlineRepo;
        this.mContext = context;
    }


    @Override
    public Observable<List<Post>> fetchPosts() {
        if(mContext != null && !Utility.isNetworkAvailable(mContext)) {
            return mOfflineRepo.fetchPosts();
        }else{
            return  mRepo.fetchPosts();
        }

    }
}

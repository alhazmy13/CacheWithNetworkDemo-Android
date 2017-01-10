package net.alhazmy13.cachewithnetworkdemo.posts.data;

import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;
import rx.Observable;

public class PostService implements PostRepository {

    private PostRepository mRepo;

    public PostService(PostRepository repo) {
        this.mRepo = repo;
    }


    @Override
    public Observable<List<Post>> fetchPosts() {
        return null;
    }
}

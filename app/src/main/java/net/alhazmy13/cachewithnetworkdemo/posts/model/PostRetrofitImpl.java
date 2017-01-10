package net.alhazmy13.cachewithnetworkdemo.posts.model;


import net.alhazmy13.cachewithnetworkdemo.posts.data.PostRepository;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

public class PostRetrofitImpl implements PostRepository {
    private static final String TAG = "UserRetrofitImpl";
    private PostRetrofitService mRetrofitService;

    public PostRetrofitImpl(PostRetrofitService retrofitService) {
        this.mRetrofitService = retrofitService;
    }



    @Override
    public Observable<List<Post>> fetchPosts() {
        return mRetrofitService.fetchPosts().map(new Func1<Response<List<Post>>, List<Post>>() {
            @Override
            public List<Post> call(Response<List<Post>> response) {
                if (response.isSuccessful())
                    return response.body();
                throw new RuntimeException(response.message());


            }

        });
    }
}



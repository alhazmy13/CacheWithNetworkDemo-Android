package net.alhazmy13.cachewithnetworkdemo.posts.presentation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.alhazmy13.cachewithnetworkdemo.R;
import net.alhazmy13.cachewithnetworkdemo.posts.data.PostService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitImpl;
import net.alhazmy13.cachewithnetworkdemo.posts.model.PostRetrofitService;
import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Retrofit;
import rx.Subscriber;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class PostFragment extends Fragment implements MyPostRecyclerViewAdapter.OnListFragmentInteractionListener {
    private static final String TAG = "PostFragment";
    private List<Post> postList = new ArrayList<>();
    @Inject
    Retrofit mRetrofit;
    private PostService mService;
    private MyPostRecyclerViewAdapter mAdapter;
    @SuppressWarnings("unused")
    public static PostFragment newInstance(int columnCount) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mService = new PostService(new PostRetrofitImpl(mRetrofit.create(PostRetrofitService.class)));
        mAdapter = new MyPostRecyclerViewAdapter(postList, this);
        fetchAllPost();
    }

    private void fetchAllPost() {
        mService.fetchPosts()
                .subscribe(new Subscriber<List<Post>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        postList.clear();
                        postList.addAll(posts);
                        
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onListFragmentInteraction(int position) {
        Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}

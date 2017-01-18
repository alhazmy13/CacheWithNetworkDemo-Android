package net.alhazmy13.cachewithnetworkdemo.posts.presentation.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import net.alhazmy13.cachewithnetworkdemo.posts.model.model.Post;

import java.util.List;

/**
 * Created by alhazmy13 on 1/16/17.
 */

class PostDiffCallback extends DiffUtil.Callback{

    private List<Post> newList;
    private List<Post> oldList;

    PostDiffCallback(List<Post> newList, List<Post> oldPersons) {
        this.newList = newList;
        this.oldList = oldPersons;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
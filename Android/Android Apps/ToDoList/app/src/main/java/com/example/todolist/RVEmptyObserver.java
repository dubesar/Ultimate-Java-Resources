package com.example.todolist;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Observer class to observe changes made to the data set in RecyclerView's Adapter
 */
public class RVEmptyObserver extends RecyclerView.AdapterDataObserver {

    // Member variables
    private Context mContext;
    private RecyclerView mRecyclerView;
    private View mEmptyView;

    // Constructor
    RVEmptyObserver(Context mContext, RecyclerView mRecyclerView, View mEmptyView) {

        // Store the passed-in Context, RecyclerView and View
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
        this.mEmptyView = mEmptyView;

        // Determine whether to display the RecyclerView or the EmptyView
        checkIfEmpty();
    }

    @Override
    public void onChanged() {
        // Call checkIfEmpty() whenever the data set is changed
        checkIfEmpty();
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
        // Call checkIfEmpty() when an item is inserted in the data set
        checkIfEmpty();
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
        // Call checkIfEmpty() when an item is removed in the data set
        checkIfEmpty();
    }

    /**
     * Method to determine which one out of the RecyclerView and the EmptyView is to be displayed.
     */
    private void checkIfEmpty() {
        if (mEmptyView != null && mRecyclerView.getAdapter() != null) {
            // Determine whether the data set is empty or not
            final boolean isEmpty = mRecyclerView.getAdapter().getItemCount() == 0;

            // Make visibility changes on the UI thread
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mEmptyView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
                    mRecyclerView.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
                }
            });
        }
    }
}

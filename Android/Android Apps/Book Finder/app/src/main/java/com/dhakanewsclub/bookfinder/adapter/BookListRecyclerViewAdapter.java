package com.dhakanewsclub.bookfinder.adapter;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhakanewsclub.bookfinder.R;
import com.dhakanewsclub.bookfinder.model.BookList;
import com.dhakanewsclub.bookfinder.model.Item;
import com.google.gson.internal.$Gson$Types;
import com.squareup.picasso.Picasso;


public class BookListRecyclerViewAdapter extends RecyclerView.Adapter<BookListRecyclerViewAdapter.ViewHolder> {
    private static final String DIBAGING_TAG = "DIBAGING_TAG";
    BookList mBookList;
    public void setBookList(BookList mBookList) {
        this.mBookList = mBookList;
        notifyDataSetChanged();
    }


//    public BookListRecyclerViewAdapter(BookList mBookList) {
//        Log.d(DIBAGING_TAG,"adapter cons"+mBookList.getItems().size());
//        this.mBookList=mBookList;
//
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item,parent,false);
        Log.d(DIBAGING_TAG,"adapter on create");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(DIBAGING_TAG,"position  :"+position);
        String author="";
        final Item item=mBookList.getItems().get(position);
        try {
            holder.mTextViewBookName.setText(item.getVolumeInfo().getTitle());
        }
        catch (Exception e){
            Log.d(DIBAGING_TAG,"error in adding book name "+e.getMessage());
        }

        for (String autho:item.getVolumeInfo().getAuthors()) {
            if (author=="")author=autho;
            else
            author=author+";\n"+autho;
        }
        try {
            holder.mTextViewBookAuthor.setText(author);
        }
        catch (Exception e){
            Log.d(DIBAGING_TAG,"error in adding author name "+e.getMessage());
        }

        try {
            Picasso.get().load(item.getVolumeInfo().getImageLinks().getSmallThumbnail().toString()).into(holder.mImageView);
        }
        catch (Exception e){
            Log.d(DIBAGING_TAG,"error in adding image "+e.getMessage());
        }




    }

    @Override
    public int getItemCount() {
        //Log.d(DIBAGING_TAG,"size is: "+mBookList.getItems().size());
        //return mBookList.getItems().size();
        return mBookList == null ? 0 : mBookList.getItems().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewBookName,mTextViewBookAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.book_image);
            mTextViewBookName=itemView.findViewById(R.id.book_name);
            mTextViewBookAuthor=itemView.findViewById(R.id.book_author);

        }

    }

}

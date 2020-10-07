package com.dhakanewsclub.bookfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.dhakanewsclub.bookfinder.adapter.BookListRecyclerViewAdapter;
import com.dhakanewsclub.bookfinder.model.BookList;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    private static final String DIBAGING_TAG = "DIBAGING_TAG";
    EditText mEditTextQuery;
    ImageButton mImageButtonSearch;
    HomeViewMode mHomeViewMode;
    RecyclerView mRecyclerView;
    BookListRecyclerViewAdapter mBookListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextQuery=findViewById(R.id.book_query_edit_text);
        mImageButtonSearch=findViewById(R.id.find_button);
        mHomeViewMode = new ViewModelProvider(this, new HomeViewModelFactory(this.getApplication(), "test")).get(HomeViewMode.class);
        mRecyclerView=findViewById(R.id.book_list_recycler);
        mHandler = new Handler();
        init();
        searchButtonOnClick();


    }

    private void bookListObserver(){
        mHomeViewMode.getBookListMutableLiveData().observe(this, new Observer<BookList>() {
            @Override
            public void onChanged(BookList bookList) {
//                initAdapter();
                mHandler.post(updateAdapterRunnable);
                mBookListRecyclerViewAdapter.notifyDataSetChanged();
                Log.d(DIBAGING_TAG,"list onchange :list:"+bookList.getItems().size());
            }
        });
    }

    private void searchButtonOnClick(){

        mImageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(DIBAGING_TAG,"search onclick");
                String query=mEditTextQuery.getText().toString();
                if(query==""||query==null){
                    return;
                }
                else {
                    Log.d(DIBAGING_TAG,"search parameter: "+query);
                    Log.d(DIBAGING_TAG,"search parameter: "+query);
                    mHomeViewMode.initAllPlace(query);


                    bookListObserver();

                }

            }
        });
    }

    private void initAdapter(){
        Log.d(DIBAGING_TAG,"init adapter: "+mHomeViewMode.getBookListMutableLiveData().getValue().getItems().size());
//        mBookListRecyclerViewAdapter=new BookListRecyclerViewAdapter(mHomeViewMode.getBookListMutableLiveData().getValue());
//        mRecyclerView.setAdapter(mBookListRecyclerViewAdapter);
    }

    private Runnable updateAdapterRunnable = new Runnable() {
        @Override
        public void run() {
            mBookListRecyclerViewAdapter.setBookList(mHomeViewMode.getBookListMutableLiveData().getValue());
        }
    };

    private void init(){

        mBookListRecyclerViewAdapter=new BookListRecyclerViewAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBookListRecyclerViewAdapter);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(updateAdapterRunnable);
    }

}
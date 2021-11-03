package org.antem.quotesapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    private QuotesAdapter mQuotesAdapter;
    private QuotesViewModel mQuotesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.myRecycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQuotesAdapter = new QuotesAdapter(this);
        mRecyclerView.setAdapter(mQuotesAdapter);


        mQuotesViewModel = new ViewModelProvider(this).get(QuotesViewModel.class);
        mQuotesViewModel.getQuotesLiveData().observe(this, quotes -> {
                mQuotesAdapter.setQuoteModelList(quotes);
        });
        mQuotesViewModel.getImagesLiveData().observe(this,images->{
            mQuotesAdapter.setImageList(images);
        });

    }
}
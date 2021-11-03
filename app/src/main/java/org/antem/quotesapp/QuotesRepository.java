package org.antem.quotesapp;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class QuotesRepository {

    private static final String QUOTES_URL = "https://type.fit/";
    private static final String IMAGES_URL = "https://api.imgflip.com";



    private QuotesService mQuotesService;

    private MutableLiveData<List<QuoteModel>> quotesResponse;
    private MutableLiveData<List<MemeModel>> imagesResponse;

    public QuotesRepository() {
        quotesResponse = new MutableLiveData<>();
        imagesResponse=new MutableLiveData<>();

    }

    public void getQuotes() {
        mQuotesService = new Retrofit.Builder()
                .baseUrl(QUOTES_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuotesService.class);
        mQuotesService.getQuotes().enqueue(new Callback<List<QuoteModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<QuoteModel>> call, @NonNull Response<List<QuoteModel>> response) {
                Log.d(TAG, "onResponse: ok");
                if (response.body() != null) {
                    quotesResponse.setValue(response.body());
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<QuoteModel>> call, @NonNull Throwable t) {

            }
        });
    }

    public void getImages(){
        mQuotesService=new Retrofit.Builder()
                .baseUrl(IMAGES_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build().create(QuotesService.class);
        mQuotesService.getImages().enqueue(new Callback<MemeDataModel>() {
            @Override
            public void onResponse(Call<MemeDataModel> call, Response<MemeDataModel> response) {
                if (response.body()!=null){
                    imagesResponse.setValue(response.body().getData().getMemes());
                }
            }

            @Override
            public void onFailure(Call<MemeDataModel> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<MemeModel>> getImagesResponse() {
        return imagesResponse;
    }

    public MutableLiveData<List<QuoteModel>> getQuotesResponse() {
        return quotesResponse;
    }
}

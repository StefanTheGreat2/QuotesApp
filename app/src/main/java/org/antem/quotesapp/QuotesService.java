package org.antem.quotesapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotesService {

    @GET("/api/quotes")
    Call<List<QuoteModel>> getQuotes();
    @GET("/get_memes/")
    Call<MemeDataModel> getImages();
}

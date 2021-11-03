package org.antem.quotesapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class QuotesViewModel extends ViewModel {
    private QuotesRepository mQuotesRepository;

    private LiveData<List<QuoteModel>> quotesLiveData;
    private LiveData<List<MemeModel>> imagesLiveData;

    public QuotesViewModel() {
        mQuotesRepository =new QuotesRepository();
        mQuotesRepository.getQuotes();
        mQuotesRepository.getImages();
        imagesLiveData=mQuotesRepository.getImagesResponse();
        quotesLiveData=mQuotesRepository.getQuotesResponse();

    }

    public LiveData<List<QuoteModel>> getQuotesLiveData() {
        return quotesLiveData;
    }

    public LiveData<List<MemeModel>> getImagesLiveData() {
        return imagesLiveData;
    }
}

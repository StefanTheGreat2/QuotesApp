package org.antem.quotesapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MemesModel {
    @SerializedName("memes")
    @Expose
    private List<MemeModel> memes;

    public List<MemeModel> getMemes() {
        return memes;
    }

    public void setMemes(List<MemeModel> memes) {
        this.memes = memes;
    }
}

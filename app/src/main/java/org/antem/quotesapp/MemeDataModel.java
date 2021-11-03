package org.antem.quotesapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MemeDataModel {
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private MemesModel data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MemesModel getData() {
        return data;
    }

    public void setData(MemesModel data) {
        this.data = data;
    }
}

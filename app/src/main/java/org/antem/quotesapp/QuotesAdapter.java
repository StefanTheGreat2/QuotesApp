package org.antem.quotesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {
    Context mContext;
    private List<QuoteModel> mQuoteModelList;
    private List<MemeModel> mImageModelList;

    public QuotesAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_quote, parent, false);

        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.QuotesViewHolder holder, int position) {
        String author = mQuoteModelList.get(position).getAuthor();
        String text = mQuoteModelList.get(position).getText();
        holder.quote.setText(text);
        if (author != null) {
            holder.author.setText(author);
        } else {
            holder.author.setText("Unknown");
        }
        if (mImageModelList != null) {
            int index = randomIndex();

            Glide.with(holder.itemView)
                    .load(mImageModelList.get(index).getUrl())
                    .into(holder.mImageView);
        }
    }

    private int randomIndex() {
        int index = (int) Math.round(Math.random() * mImageModelList.size()) - 1;
        if (index >= 0 && index < mImageModelList.size()) {
            return index;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mQuoteModelList != null) {
            return mQuoteModelList.size();
        }
        return 0;
    }

    public void setQuoteModelList(List<QuoteModel> quoteModelList) {
        mQuoteModelList = quoteModelList;
        notifyDataSetChanged();
    }

    public void setImageList(List<MemeModel> images) {
        this.mImageModelList = images;
        notifyDataSetChanged();

    }


    public static class QuotesViewHolder extends RecyclerView.ViewHolder {
        TextView author, quote;
        ImageView mImageView;

        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            quote = itemView.findViewById(R.id.quote);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}

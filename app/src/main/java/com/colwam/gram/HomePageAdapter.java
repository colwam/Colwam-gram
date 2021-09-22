package com.colwam.gram;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {

    private String[] eventnames;
    private int[] imageIds;

    public HomePageAdapter(String [] eventnames,int [] imageIds)
    {
        this.eventnames = eventnames;
        this.imageIds = imageIds;

    }

    @Override
    public int getItemCount() {
        return eventnames.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView view =  (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(eventnames[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(eventnames[position]);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;

        public ViewHolder(CardView view)
        {
            super(view);
            cardView = view;
        }

    }
}

package org.tek.geza.bestmovies.view.adapter.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.tek.geza.bestmovies.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_overview)
    public TextView tvOverView;
    @BindView(R.id.tv_rating)
    public TextView tvRating;
    @BindView(R.id.tv_year)
    public TextView tvYear;
    @BindView(R.id.iv_poster)
    public ImageView ivPosterImage;
    WeakReference<Context> contextWeakReference;

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        contextWeakReference = new WeakReference<>(itemView.getContext());
    }

    public Context context() {
        return contextWeakReference.get();
    }
}

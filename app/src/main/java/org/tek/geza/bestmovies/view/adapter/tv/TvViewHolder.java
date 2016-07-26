package org.tek.geza.bestmovies.view.adapter.tv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.tek.geza.bestmovies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvViewHolder extends RecyclerView.ViewHolder {

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

    public TvViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

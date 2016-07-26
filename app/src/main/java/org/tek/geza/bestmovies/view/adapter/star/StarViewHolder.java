package org.tek.geza.bestmovies.view.adapter.star;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.tek.geza.bestmovies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StarViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    public TextView tvName;
    @BindView(R.id.iv_poster)
    public ImageView ivPosterImage;
    @BindView(R.id.tv_movies)
    public TextView tvMovies;

    public StarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

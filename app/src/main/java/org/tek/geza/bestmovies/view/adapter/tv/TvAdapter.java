package org.tek.geza.bestmovies.view.adapter.tv;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.tek.geza.bestmovies.R;
import org.tek.geza.bestmovies.model.tv.list.TvShow;
import org.tek.geza.bestmovies.view.IntentFactory;
import org.tek.geza.bestmovies.view.adapter.DetailStarter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvViewHolder> {
    private static final String PATH_BASE = "http://image.tmdb.org/t/p/w300/";

    List<TvShow> data;
    WeakReference<AppCompatActivity> activityWeakReference;

    public TvAdapter(AppCompatActivity activity) {
        data = new ArrayList<>(20);
        activityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_content_list, parent, false);
        TvViewHolder holder = new TvViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TvViewHolder holder, int position) {
        final TvShow movie = data.get(position);
        if (TvShow.ERROR == movie.getId()) {
            return;
        }
        holder.tvOverView.setText(movie.getOverview());
        holder.tvRating.setText(movie.getVoteAverage() + "");
        holder.tvTitle.setText(movie.getName());
        holder.tvYear.setText(movie.getFirstAirDate().substring(0,4));
        Picasso.with(holder.itemView.getContext())
                .load(PATH_BASE + movie.getPosterPath())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .into(holder.ivPosterImage);
        if (activityWeakReference.get() != null) {
            holder.itemView.setOnClickListener(new DetailStarter(activityWeakReference.get(), IntentFactory.TVSHOW, movie.getId()));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addTvShow(TvShow movie) {
        data.add(movie);
    }

    public void clear() {
        data.clear();
    }
}

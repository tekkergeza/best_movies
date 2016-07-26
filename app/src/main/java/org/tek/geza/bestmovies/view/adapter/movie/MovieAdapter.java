package org.tek.geza.bestmovies.view.adapter.movie;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.tek.geza.bestmovies.R;
import org.tek.geza.bestmovies.model.movie.list.Movie;
import org.tek.geza.bestmovies.view.IntentFactory;
import org.tek.geza.bestmovies.view.adapter.DetailStarter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private static final String PATH_BASE = "http://image.tmdb.org/t/p/w300/";
    List<Movie> data;
    WeakReference<AppCompatActivity> activity;

    public MovieAdapter(AppCompatActivity appCompatActivity) {
        activity = new WeakReference<>(appCompatActivity);
        data = new ArrayList<>(20);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_content_list, parent, false);
        MovieViewHolder holder = new MovieViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = data.get(position);
        if (Movie.ERROR == movie.getId()) {
            return;
        }

        holder.tvOverView.setText(movie.getOverview());
        holder.tvRating.setText(movie.getVoteAverage() + "");
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getReleaseDate().substring(0,4));
        Picasso.with(holder.itemView.getContext())
                .load(PATH_BASE + movie.getPosterPath())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .into(holder.ivPosterImage);
        if (activity.get() != null && movie.getId() != null) {
            holder.itemView.setOnClickListener(new DetailStarter(activity.get(), IntentFactory.MOVIE, movie.getId()));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addMovie(Movie movie) {
        data.add(movie);
    }


    public void clear() {
        data.clear();
    }
}

package org.tek.geza.bestmovies.util.transformer;

import org.tek.geza.bestmovies.model.movie.list.Movie;
import org.tek.geza.bestmovies.model.movie.response.MovieResponse;
import org.tek.geza.bestmovies.model.movie.response.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class MovieTransformer implements Func1<MovieResponse, Observable<Movie>> {

    @Inject
    MovieTransformer() {

    }

    @Override
    public Observable<Movie> call(MovieResponse movieResponse) {
        List<Result> results = movieResponse.getResults();
        List<Movie> movies = new ArrayList<>(30);
        for (Result r : results) {
            Movie movie = new Movie();
            movie.setId(r.getId());
            movie.setVoteAverage(r.getVoteAverage());
            movie.setReleaseDate(r.getReleaseDate());
            movie.setTitle(r.getTitle());
            movie.setOriginalTitle(r.getOriginalTitle());
            movie.setOverview(r.getOverview());
            movie.setPosterPath(r.getPosterPath());
            movies.add(movie);
        }
        return Observable.from(movies);
    }
}
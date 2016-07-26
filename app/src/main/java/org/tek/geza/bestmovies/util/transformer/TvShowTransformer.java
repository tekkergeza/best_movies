package org.tek.geza.bestmovies.util.transformer;

import org.tek.geza.bestmovies.model.tv.list.TvShow;
import org.tek.geza.bestmovies.model.tv.response.Result;
import org.tek.geza.bestmovies.model.tv.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class TvShowTransformer implements Func1<TvShowResponse, Observable<TvShow>> {

    @Inject
    public TvShowTransformer() {

    }

    @Override
    public Observable<TvShow> call(TvShowResponse tvShowResponse) {
        List<Result> results = tvShowResponse.getResults();
        List<TvShow> movies = new ArrayList<>(30);
        for (Result r : results) {
            TvShow movie = new TvShow();
            movie.setId(r.getId());
            movie.setVoteAverage(r.getVoteAverage());
            movie.setFirstAirDate(r.getFirstAirDate());
            movie.setName(r.getName());
            movie.setOriginalName(r.getOriginalName());
            movie.setOverview(r.getOverview());
            movie.setPosterPath(r.getPosterPath());
            movies.add(movie);
        }
        return Observable.from(movies);
    }
}

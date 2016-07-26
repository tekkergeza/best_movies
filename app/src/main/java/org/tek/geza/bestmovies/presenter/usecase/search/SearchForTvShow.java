package org.tek.geza.bestmovies.presenter.usecase.search;

import org.tek.geza.bestmovies.model.repository.TvRepository;
import org.tek.geza.bestmovies.model.tv.list.TvShow;
import org.tek.geza.bestmovies.presenter.usecase.UseCase;

import javax.inject.Inject;

import rx.Observable;

public class SearchForTvShow implements UseCase<Observable<TvShow>, String> {

    TvRepository repository;

    @Inject
    public SearchForTvShow(TvRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<TvShow> execute(String query) {
        return repository.searchTopTvShows(query);
    }
}

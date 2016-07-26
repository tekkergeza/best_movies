package org.tek.geza.bestmovies.presenter;

import org.tek.geza.bestmovies.model.people.Star;
import org.tek.geza.bestmovies.presenter.usecase.load.GetFamousPeople;
import org.tek.geza.bestmovies.presenter.usecase.search.SearchStars;

import javax.inject.Inject;

import rx.Observable;

public class PeoplePresenter {

    GetFamousPeople getFamousPeople;
    SearchStars searchStars;

    @Inject
    public PeoplePresenter(GetFamousPeople getFamousPeople, SearchStars searchStars) {
        this.getFamousPeople = getFamousPeople;
        this.searchStars = searchStars;
    }

    public Observable<Star> refreshList() {
        return getFamousPeople.execute(null);
    }

    public Observable<Star> searchStars(String query) {
        return searchStars.execute(query);
    }
}

package org.tek.geza.bestmovies.util.transformer;


import org.tek.geza.bestmovies.model.people.Star;
import org.tek.geza.bestmovies.model.people.response.KnownFor;
import org.tek.geza.bestmovies.model.people.response.Result;
import org.tek.geza.bestmovies.model.people.response.StarResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class StarTransformer implements Func1<StarResponse, Observable<Star>> {

    @Inject
    public StarTransformer() {

    }

    @Override
    public Observable<Star> call(StarResponse starResponse) {
        List<Result> results = starResponse.getResults();
        List<Star> stars = new ArrayList<>(30);
        for (Result r : results) {
            Star star = new Star();
            star.setId(r.getId());
            star.setName(r.getName());
            StringBuilder sb = new StringBuilder();
            for(KnownFor kf : r.getKnownFor()){
                sb.append(kf.getTitle()).append("\n");
            }
            star.setMovies(sb.toString());
            star.setProfilePath(r.getProfilePath());
            stars.add(star);
        }
        return Observable.from(stars);
    }
}

package org.tek.geza.bestmovies.presenter;

import org.tek.geza.bestmovies.model.movie.detail.MovieDetails;
import org.tek.geza.bestmovies.model.movie.list.Movie;
import org.tek.geza.bestmovies.presenter.usecase.load.GetMovieDetails;
import org.tek.geza.bestmovies.presenter.usecase.load.GetTop20Movies;
import org.tek.geza.bestmovies.presenter.usecase.search.SearchForMovie;

import javax.inject.Inject;

import rx.Observable;

public class MoviePresenter {

    GetTop20Movies getTop20Movies;
    GetMovieDetails getMovieDetails;
    SearchForMovie searchForMovie;

    @Inject
    public MoviePresenter(GetTop20Movies getTop20Movies, GetMovieDetails movieDetails, SearchForMovie searchForMovie) {
        this.getTop20Movies = getTop20Movies;
        this.getMovieDetails = movieDetails;
        this.searchForMovie = searchForMovie;
    }

    public Observable<Movie> refreshList() {
        return getTop20Movies.execute(null);
    }

    public Observable<MovieDetails> getMovieDetail(int id) {
        return getMovieDetails.execute(id);
    }

    public Observable<Movie> searchMovie(String s) {
        return searchForMovie.execute(s);
    }
}

package org.tek.geza.bestmovies.model;

import org.tek.geza.bestmovies.model.movie.detail.MovieDetails;
import org.tek.geza.bestmovies.model.movie.response.MovieResponse;
import org.tek.geza.bestmovies.model.people.response.StarResponse;
import org.tek.geza.bestmovies.model.tv.detail.TvShowDetail;
import org.tek.geza.bestmovies.model.tv.response.TvShowResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieDbApi {

    // STAR
    @GET("person/popular")
    Observable<StarResponse> getPopularPeople();

    // MOVIE
    @GET("movie/top_rated")
    Observable<MovieResponse> getTopMovies();

    @GET("movie/{id}")
    Observable<MovieDetails> getMovieDetail(@Path("id") int id);

    // TV SHOW
    @GET("tv/popular")
    Observable<TvShowResponse> getPopularTvShows();

    @GET("tv/{id}")
    Observable<TvShowDetail> getTvShowDetail(@Path("id") int id);

    // SEARCH
    @GET("search/movie")
    Observable<MovieResponse> searchMovies(@Query("query") String query);

    @GET("search/tv")
    Observable<TvShowResponse> searchTvShows(@Query("query") String query);

    @GET("search/person")
    Observable<StarResponse> searchStars(@Query("query") String query);

}

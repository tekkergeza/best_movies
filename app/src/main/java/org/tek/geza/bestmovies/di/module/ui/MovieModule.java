package org.tek.geza.bestmovies.di.module.ui;

import android.support.v7.app.AppCompatActivity;

import org.tek.geza.bestmovies.view.adapter.movie.MovieAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieModule {

    @Provides
    MovieAdapter provideMovieAdapter(AppCompatActivity appCompatActivity){
        return new MovieAdapter(appCompatActivity);
    }

}

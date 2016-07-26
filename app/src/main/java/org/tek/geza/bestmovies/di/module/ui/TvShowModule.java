package org.tek.geza.bestmovies.di.module.ui;

import android.support.v7.app.AppCompatActivity;

import org.tek.geza.bestmovies.view.adapter.tv.TvAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class TvShowModule {
    @Provides
    TvAdapter provideMovieAdapter(AppCompatActivity appCompatActivity){
        return new TvAdapter(appCompatActivity);
    }
}

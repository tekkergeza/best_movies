package org.tek.geza.bestmovies.di.module.ui;

import org.tek.geza.bestmovies.view.adapter.star.StarAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {

    @Provides
    StarAdapter provideStarAdapter() {
        return new StarAdapter();
    }

}

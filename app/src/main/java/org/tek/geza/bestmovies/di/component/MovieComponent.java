package org.tek.geza.bestmovies.di.component;

import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.di.module.NetworkModule;
import org.tek.geza.bestmovies.di.module.ui.MovieModule;
import org.tek.geza.bestmovies.view.activity.MovieDetailActivity;
import org.tek.geza.bestmovies.view.fragment.MovieFragment;

import dagger.Component;

@Component(modules = {
        ActivityModule.class,
        NetworkModule.class,
        MovieModule.class
})
public interface MovieComponent extends ActivityComponent {
    void inject(MovieFragment fragment);
    void inject(MovieDetailActivity activity);
}

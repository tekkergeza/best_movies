package org.tek.geza.bestmovies.di.component;

import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.di.module.NetworkModule;
import org.tek.geza.bestmovies.di.module.ui.TvShowModule;
import org.tek.geza.bestmovies.view.activity.TvShowDetailActivity;
import org.tek.geza.bestmovies.view.fragment.TvShowFragment;

import dagger.Component;

@Component(modules = {
        ActivityModule.class,
        NetworkModule.class,
        TvShowModule.class
})
public interface TvShowComponent extends ActivityComponent {
    void inject(TvShowFragment fragment);
    void inject(TvShowDetailActivity activity);
}

package org.tek.geza.bestmovies.di.component;

import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.di.module.NetworkModule;
import org.tek.geza.bestmovies.di.module.ui.PersonModule;
import org.tek.geza.bestmovies.view.fragment.StarFragment;

import dagger.Component;

@Component(
        modules = {
            ActivityModule.class,
            NetworkModule.class,
            PersonModule.class
})
public interface PersonComponent extends ActivityComponent {
    void inject(StarFragment fragment);
}

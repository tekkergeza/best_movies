package org.tek.geza.bestmovies.di.component;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import org.tek.geza.bestmovies.util.network.ErrorHandler;
import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.view.activity.DetailActivity;
import org.tek.geza.bestmovies.view.activity.MainActivity;

import dagger.Component;

@Component(modules = {
        ActivityModule.class
})
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(DetailActivity activity);

    Context getContext();
    FragmentManager getFragmentManager();
    AppCompatActivity getAppcompatActivity();
    ErrorHandler getErrorHandler();
    LinearLayoutManager getLayoutManager();
}

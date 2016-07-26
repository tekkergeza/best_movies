package org.tek.geza.bestmovies.view.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.util.network.ErrorHandler;

public abstract class BaseActivity extends AppCompatActivity implements ErrorHandler {

    ActivityModule module;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        module = new ActivityModule(this, this);

    }

    public ActivityModule getComponent() {
        return module;
    }
}

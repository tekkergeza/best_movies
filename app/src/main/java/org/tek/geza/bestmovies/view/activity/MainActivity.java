package org.tek.geza.bestmovies.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.EditText;

import org.tek.geza.bestmovies.R;
import org.tek.geza.bestmovies.di.component.ActivityComponent;
import org.tek.geza.bestmovies.di.component.DaggerActivityComponent;
import org.tek.geza.bestmovies.util.OnTextClearedWatcher;
import org.tek.geza.bestmovies.util.SearchListener;
import org.tek.geza.bestmovies.util.network.RetrofitException;
import org.tek.geza.bestmovies.view.adapter.MovieDbPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.view_pager_main)
    ViewPager viewPager;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.view_pager_header)
    PagerTitleStrip titleStrip;

    @BindView(R.id.et_search)
    EditText searchTextView;

    @Inject
    MovieDbPager pagerAdapter;

    @Inject
    SearchListener searchListener;

    @Inject
    OnTextClearedWatcher watcher;

    ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        inject();
        setupViewPager();
        searchTextView.setOnEditorActionListener(searchListener);
        searchTextView.addTextChangedListener(watcher);
    }


    private void setupViewPager() {
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        titleStrip.setTextColor(Color.WHITE);
        titleStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
    }

    private void inject() {
        component = DaggerActivityComponent.builder()
                .activityModule(module)
                .build();
        component.inject(this);
    }

    @Override
    public void onError(Throwable t) {
        // Crashlytics.logException()
        if (((RetrofitException) t).isNetworkError()) {
            Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_SHORT).show();
        } else if (((RetrofitException) t).getCode() != 0) {
            Snackbar.make(coordinatorLayout, "Oops, server is on fire!", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(coordinatorLayout, "Oops, we are working on this issue!", Snackbar.LENGTH_SHORT).show();
        }

    }


}

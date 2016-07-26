package org.tek.geza.bestmovies.view.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.tek.geza.bestmovies.R;
import org.tek.geza.bestmovies.di.module.ActivityModule;
import org.tek.geza.bestmovies.util.network.ErrorHandler;
import org.tek.geza.bestmovies.util.network.RetrofitException;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public abstract class DetailActivity extends AppCompatActivity implements ErrorHandler {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_original_title)
    TextView tvOriginalTitle;

    @BindView(R.id.tv_year)
    TextView tvYear;

    @BindView(R.id.tv_rating)
    TextView tvRating;

    @BindView(R.id.tv_genre)
    TextView tvGenre;

    @BindView(R.id.tv_budget)
    TextView tvBudget;

    @BindView(R.id.tv_country)
    TextView tvCountry;

    @BindView(R.id.tv_overview)
    TextView tvOverview;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    ActivityModule activityModule;

    CompositeSubscription subscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        subscriptions = new CompositeSubscription();
        activityModule = new ActivityModule(this, this);
        inject();
        bindData(getIntent().getIntExtra("ID", -1));
    }

    protected abstract void bindData(int id);

    protected ActivityModule getActivityModule() {
        return activityModule;
    }

    abstract protected void inject();

    @Override
    public void onError(Throwable t) {
        // Crashlytics.logException()
        if (t instanceof RetrofitException) {
            if (((RetrofitException) t).isNetworkError()) {
                Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_SHORT).show();
            } else if (((RetrofitException) t).getCode() != 0) {
                Snackbar.make(coordinatorLayout, "Oops, server is on fire!", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(coordinatorLayout, "Oops, we are working on this issue!", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            Snackbar.make(coordinatorLayout, "Oops, we are working on this issue!", Snackbar.LENGTH_SHORT).show();
        }
    }
}


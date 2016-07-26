package org.tek.geza.bestmovies.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.tek.geza.bestmovies.view.activity.MovieDetailActivity;
import org.tek.geza.bestmovies.view.activity.TvShowDetailActivity;

public class IntentFactory {

    public static final String TAG = IntentFactory.class.getSimpleName();

    public static final int MOVIE = 0;
    public static final int TVSHOW = 1;

    public static Intent getDetailIntent(Context context, int type, int id) {

        Intent intent;
        switch (type) {
            case MOVIE:
                intent = new Intent(context, MovieDetailActivity.class);
                break;
            case TVSHOW:
                intent = new Intent(context, TvShowDetailActivity.class);
                break;
            default:
                Log.d(TAG, "invald intent type: " + type);
                return null;
        }
        intent.putExtra("ID", id);
        return intent;
    }
}

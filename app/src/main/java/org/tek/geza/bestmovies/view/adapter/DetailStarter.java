package org.tek.geza.bestmovies.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.tek.geza.bestmovies.util.network.ErrorHandler;
import org.tek.geza.bestmovies.util.network.RetrofitException;
import org.tek.geza.bestmovies.view.IntentFactory;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class DetailStarter implements View.OnClickListener {

    Intent intent;
    WeakReference<AppCompatActivity> activity;

    public DetailStarter(AppCompatActivity context, int type, int id) {
        intent = IntentFactory.getDetailIntent(context, type, id);
        activity = new WeakReference<>(context);

    }

    @Override
    public void onClick(View view) {
        if (activity.get() != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) activity.get().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            if (isConnected) {
                activity.get().startActivity(intent);
            } else {
                ((ErrorHandler) activity.get()).onError(RetrofitException.networkError(new IOException()));
            }
        }
    }
}

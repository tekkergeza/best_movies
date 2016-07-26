package org.tek.geza.bestmovies.util;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.tek.geza.bestmovies.util.event.SearchRequestEvent;

public class SearchListener implements TextView.OnEditorActionListener {

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//        if (v.getText().length() >= 3) {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                EventBus.getDefault().post(new SearchRequestEvent(v.getText()));
                return true;
            }
//        }
        return false;
    }
}
package org.tek.geza.bestmovies.util;

import android.text.Editable;
import android.text.TextWatcher;

import org.greenrobot.eventbus.EventBus;
import org.tek.geza.bestmovies.util.event.LoadRequestEvent;

import javax.inject.Inject;

public class OnTextClearedWatcher implements TextWatcher {

    @Inject
    public OnTextClearedWatcher() {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() == 0) {
            EventBus.getDefault().post(new LoadRequestEvent());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

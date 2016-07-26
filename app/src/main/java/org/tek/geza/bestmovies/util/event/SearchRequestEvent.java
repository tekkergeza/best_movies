package org.tek.geza.bestmovies.util.event;

public class SearchRequestEvent {

    CharSequence query;

    public SearchRequestEvent(CharSequence text) {
        query = text;
    }

    public CharSequence getQuery() {
        return query;
    }
}

package org.tek.geza.bestmovies.presenter.usecase;

public interface UseCase<R, P> {
    R execute(P param);
}

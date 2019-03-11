package com.kotlin.githubapi.ui.base.paged;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public abstract class BaseItemKeyedDataSource<Key, Value> extends ItemKeyedDataSource<Key, Value> {

    protected Boolean isCanLoadMore = true;

    private final MutableLiveData<PageState> pageState = new MutableLiveData<>();
    private final MutableLiveData<PageState> initialPageState = new MutableLiveData<>();

    private Completable retryCompletable;
    private Completable startCompletable;
    private Completable loadAfterCompletable;

    protected abstract Integer getNextPage();

    public void retry(CompositeDisposable compositeDisposable) {
        if (retryCompletable == null) return;
        compositeDisposable.add(retryCompletable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }, Timber::e)
        );
    }

    public void start(CompositeDisposable compositeDisposable) {
        if (startCompletable == null) return;
        compositeDisposable.add(startCompletable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }, Timber::e)
        );
    }

    protected <T> Observable<T> zipWithTimer(Observable<T> observable) {
        return Observable.zip(observable,
                Observable.timer(500, TimeUnit.MILLISECONDS), (t, timerValue) -> t);
    }

    @NonNull
    public MutableLiveData<PageState> getPageState() {
        return pageState;
    }

    @NonNull
    public MutableLiveData<PageState> getInitialPageState() {
        return initialPageState;
    }

    protected void setRetry(@Nullable final Action action) {
        retryCompletable = action != null ? Completable.fromAction(action) : null;
    }

    protected void setStart(@Nullable final Action action) {
        startCompletable = action != null ? Completable.fromAction(action) : null;
    }

    protected void setLoadAfterCompletable(final Action action) {
        this.loadAfterCompletable = action != null ? Completable.fromAction(action) : null;
    }

    protected void cleanupState() {
        initialPageState.setValue(null);
        pageState.setValue(null);
    }
}

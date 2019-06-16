package com.kotlin.githubapi.ui.usersearch;

import com.kotlin.githubapi.data.user.parameter.SearchUserParameters;
import com.kotlin.githubapi.data.user.response.User;
import com.kotlin.githubapi.domain.user.GetUsersUseCase;
import com.kotlin.githubapi.ui.base.paged.BaseItemKeyedDataSource;
import com.kotlin.githubapi.ui.base.paged.PageState;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class UserSearchDataSource extends BaseItemKeyedDataSource<SearchUserParameters, List<User>> {

    private final SearchUserParameters parameters;
    private final GetUsersUseCase getUsersUseCase;
    private final CompositeDisposable compositeDisposable;

    public UserSearchDataSource(SearchUserParameters parameters,
                          GetUsersUseCase getUsersUseCase,
                          CompositeDisposable compositeDisposable) {
        this.parameters = parameters;
        this.getUsersUseCase = getUsersUseCase;
        this.compositeDisposable = compositeDisposable;
    }

//    @Override
//    protected Integer getNextPage() {
//        return parameters.getPage() + 1;
//    }

//    @Override
//    protected void setIsCanLoadMore(@NonNull final Meta meta) {
//        isCanLoadMore = meta.getCurrentPage() < meta.getLastPage();
//    }

    @NonNull
    @Override
    public SearchUserParameters getKey(@NonNull List<User> items) {
        return parameters;
    }

    @Override
    public void loadInitial(@NonNull ItemKeyedDataSource.LoadInitialParams<SearchUserParameters> params,
                            @NonNull ItemKeyedDataSource.LoadInitialCallback<List<User>> callback) {
        setStart(() -> loadInitial(params, callback));
        if (isInvalidParameters()) return;
        getInitialPageState().postValue(PageState.LOADING);
        // setup
//        parameters.setPage(1);
//        parameters.setPerPage(params.requestedLoadSize);
//        // loading
//        compositeDisposable.add(getUsersUseCase
//                .run(parameters)
//                .doOnError(throwable -> setRetry(() -> loadInitial(params, callback)))
//                .subscribe(onSubscribeLoadInitial(callback), onErrorLoadInitial()));
    }

    @Override
    public void loadAfter(@NonNull ItemKeyedDataSource.LoadParams<SearchUserParameters> params,
                          @NonNull ItemKeyedDataSource.LoadCallback<List<User>> callback) {
        if (!isCanLoadMore) return;
        getPageState().postValue(PageState.LOADING);
        // setup
//        parameters.setPage(getNextPage());
//        // loading
//        compositeDisposable.add(getUsersUseCase
//                .run(parameters)
//                .doOnError(throwable -> setRetry(() -> loadAfter(params, callback)))
//                .subscribe(onSubscribeLoadAfter(callback), onErrorLoadAfter()));
    }

    @Override
    public void loadBefore(@NonNull ItemKeyedDataSource.LoadParams<SearchUserParameters> params,
                           @NonNull ItemKeyedDataSource.LoadCallback<List<User>> callback) {
    }

    private Consumer<List<User>> onSubscribeLoadInitial(@NonNull final ItemKeyedDataSource.LoadCallback<List<User>> callback) {
        return tasks -> {
            setRetry(null);
//            if (tasks.getTasks().isEmpty()) {
//                getInitialPageState().postValue(PageState.EMPTY);
//            } else {
//                getInitialPageState().postValue(PageState.LOADED);
//            }
//            setIsCanLoadMore(tasks.getMeta());
//            callback.onResult(TaskCatalogUIData.Producer.listInstance(tasks));
        };
    }

    private Consumer<Throwable> onErrorLoadInitial() {
        return throwable -> {
//            Timber.e(throwable);
//            if (throwable instanceof ServerError) {
//                final PageState error = PageState.error(throwable.getMessage());
//                getInitialPageState().postValue(error);
//            }
        };
    }

    private Consumer<List<User>> onSubscribeLoadAfter(@NonNull final ItemKeyedDataSource.LoadCallback<List<User>> callback) {
        return tasks -> {
            setRetry(null);
            getPageState().postValue(PageState.LOADED);
//            setIsCanLoadMore(tasks.getMeta());
//            callback.onResult(TaskCatalogUIData.Producer.listInstance(tasks));
        };
    }

    private Consumer<Throwable> onErrorLoadAfter() {
        return throwable -> {
//            Timber.e(throwable);
//            if (throwable instanceof ServerError) {
//                final PageState error = PageState.error(throwable.getMessage());
//                getPageState().postValue(error);
//            }
        };
    }

    private Boolean isInvalidParameters() {
        return parameters.getPage() == null;
    }
}
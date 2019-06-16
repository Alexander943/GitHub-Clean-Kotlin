package com.kotlin.githubapi.ui.usersearch

import androidx.paging.ItemKeyedDataSource
import com.kotlin.githubapi.data.user.parameter.SearchUserParameters
import com.kotlin.githubapi.data.user.response.User
import com.kotlin.githubapi.domain.user.GetUsersUseCase
import com.kotlin.githubapi.ui.base.paged.BaseItemKeyedDataSource
import com.kotlin.githubapi.ui.base.paged.PageState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

class UserSearchDataSource(private val parameters: SearchUserParameters,
                           private val getUsersUseCase: GetUsersUseCase,
                           private val compositeDisposable: CompositeDisposable
) : BaseItemKeyedDataSource<SearchUserParameters, List<User>>() {

    private val isInvalidParameters: Boolean
        get() = parameters.page == null

    //    @Override
    //    protected Integer getNextPage() {
    //        return parameters.getPage() + 1;
    //    }

    //    @Override
    //    protected void setIsCanLoadMore(@NonNull final Meta meta) {
    //        isCanLoadMore = meta.getCurrentPage() < meta.getLastPage();
    //    }

    override fun getKey(items: List<User>): SearchUserParameters = parameters

    override fun loadInitial(params: ItemKeyedDataSource.LoadInitialParams<SearchUserParameters>,
                             callback: ItemKeyedDataSource.LoadInitialCallback<List<User>>) {
        setStart (Action{ loadInitial(params, callback) })
        if (isInvalidParameters) return
        initialPageState.postValue(PageState.LOADING)
        // setup
        //        parameters.setPage(1);
        //        parameters.setPerPage(params.requestedLoadSize);
        //        // loading
        //        compositeDisposable.add(getUsersUseCase
        //                .run(parameters)
        //                .doOnError(throwable -> setRetry(() -> loadInitial(params, callback)))
        //                .subscribe(onSubscribeLoadInitial(callback), onErrorLoadInitial()));
    }

    override fun loadAfter(params: ItemKeyedDataSource.LoadParams<SearchUserParameters>,
                           callback: ItemKeyedDataSource.LoadCallback<List<User>>) {
        if (!isCanLoadMore) return
        pageState.postValue(PageState.LOADING)
        // setup
        //        parameters.setPage(getNextPage());
        //        // loading
        //        compositeDisposable.add(getUsersUseCase
        //                .run(parameters)
        //                .doOnError(throwable -> setRetry(() -> loadAfter(params, callback)))
        //                .subscribe(onSubscribeLoadAfter(callback), onErrorLoadAfter()));
    }

    override fun loadBefore(params: ItemKeyedDataSource.LoadParams<SearchUserParameters>,
                            callback: ItemKeyedDataSource.LoadCallback<List<User>>) {
    }

    private fun onSubscribeLoadInitial(callback: ItemKeyedDataSource.LoadCallback<List<User>>): Consumer<List<User>> {
        return Consumer { tasks ->
//            setRetry(null)
//            if (tasks.getTasks().isEmpty()) {
//                getInitialPageState().postValue(PageState.EMPTY);
//            } else {
//                getInitialPageState().postValue(PageState.LOADED);
//            }
//            setIsCanLoadMore(tasks.getMeta());
//            callback.onResult(TaskCatalogUIData.Producer.listInstance(tasks));
        }
    }

    private fun onErrorLoadInitial(): Consumer<Throwable> {
        return Consumer { throwable ->
            //            Timber.e(throwable);
            //            if (throwable instanceof ServerError) {
            //                final PageState error = PageState.error(throwable.getMessage());
            //                getInitialPageState().postValue(error);
            //            }
        }
    }

    private fun onSubscribeLoadAfter(callback: ItemKeyedDataSource.LoadCallback<List<User>>): Consumer<List<User>> {
        return Consumer { tasks ->
            setRetry(null)
            pageState.postValue(PageState.LOADED)
            //            setIsCanLoadMore(tasks.getMeta());
            //            callback.onResult(TaskCatalogUIData.Producer.listInstance(tasks));
        }
    }

    private fun onErrorLoadAfter(): Consumer<Throwable> {
        return Consumer { throwable ->
            //            Timber.e(throwable);
            //            if (throwable instanceof ServerError) {
            //                final PageState error = PageState.error(throwable.getMessage());
            //                getPageState().postValue(error);
            //            }
        }
    }
}
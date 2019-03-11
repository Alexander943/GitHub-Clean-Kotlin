package com.kotlin.githubapi.ui.base.paged;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BasePagedAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    protected PageState pageState;
    private Boolean isLoading = false;

    public BasePagedAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    public BasePagedAdapter(@NonNull AsyncDifferConfig<T> config) {
        super(config);
    }

    public void setPageState(PageState newPageState) {
        if (getCurrentList() == null || getCurrentList().isEmpty()) return;
        if (Objects.equals(newPageState, PageState.LOADING)) {
            isLoading = true;
            notifyItemChanged(getItemCount() - 1);
        } else if (newPageState != null && newPageState.getPageLoadStatus() != null) {
            switch (newPageState.getPageLoadStatus()) {
                case RUNNING:
                    if (isLoading) return;
                    isLoading = true;
                    notifyItemInserted(getItemCount());
                    break;
                case SUCCESS:
                case EMPTY:
                case FAILED:
                    isLoading = false;
                    notifyItemRemoved(getItemCount());
                    break;
            }
        }
    }

    public Boolean isEmpty() {
        return getItemCount() <= 0;
    }

    public T getItem(@NonNull final Integer position) {
        return super.getItem(position);
    }

    protected boolean hasExtraRow() {
        return isLoading;
    }
}

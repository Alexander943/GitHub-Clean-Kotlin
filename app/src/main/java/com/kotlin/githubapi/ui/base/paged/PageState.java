package com.kotlin.githubapi.ui.base.paged;

public class PageState {

    public static PageState LOADED = new PageState(PageLoadStatus.SUCCESS);
    public static PageState LOADING = new PageState(PageLoadStatus.RUNNING);
    public static PageState EMPTY = new PageState(PageLoadStatus.EMPTY);

    public static PageState error(String message) {
        return new PageState(PageLoadStatus.FAILED, message == null ? "unknown error" : message);
    }

    private PageLoadStatus pageLoadStatus;
    private String message;

    private PageState(PageLoadStatus pageLoadStatus, String message) {
        this.pageLoadStatus = pageLoadStatus;
        this.message = message;
    }

    private PageState(PageLoadStatus pageLoadStatus) {
        this.pageLoadStatus = pageLoadStatus;
    }

    public PageLoadStatus getPageLoadStatus() {
        return pageLoadStatus;
    }

    public String getMessage() {
        return message;
    }
}

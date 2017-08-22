package com.collect.nettyInAction;

/**
 * Created by lifana on 2017/6/8.
 */
public interface Fetcher {
    void fetchData(FetcherCallback callback);
}

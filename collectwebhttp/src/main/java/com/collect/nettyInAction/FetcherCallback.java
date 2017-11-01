package com.collect.nettyInAction;

/**
 * Created by lifana on 2017/6/8.
 */
public interface FetcherCallback {
    void onData(Data data) throws Exception;
    void onError(Throwable cause);
}

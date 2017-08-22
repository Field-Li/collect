package com.collect.nettyInAction;

/**
 * Created by lifana on 2017/6/8.
 */

public class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data){
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}

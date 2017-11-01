package com.collect.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by lifana on 2017/5/24.
 */
public class MainTest {

    LoadingCache<String, Integer> cache;

    MainTest(){
        cache = CacheBuilder.newBuilder().maximumSize(1000).refreshAfterWrite(10, TimeUnit.MINUTES).build(
                new CacheLoader<String, Integer>() {
                    public Integer load(String key) { // no checked exception
                        System.out.println("key : " + key);
                        return 100;
                    }
                }
        );
    }

    public static void main(String args[]) throws Exception{
        MainTest test = new MainTest();
        for(int i = 0; i < 2; i++){
            test.cache.get("ss");
        }
        test.cache.get("tt");

        String ss = UUID.randomUUID().toString();
    }
}

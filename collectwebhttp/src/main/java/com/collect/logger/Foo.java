package com.collect.logger;

/**
 * Created by lifana on 2017/7/24.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
    public static final int a = 3;
    static final Logger logger = LoggerFactory.getLogger(Foo.class);

    public void doIt() {
        logger.debug("Did it again!");
    }
}
package com.lhk.util.app;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2020/12/18 9:51
 *
 * @author deepq_lh
 * @version 1.0.0
 */
public class ThreadApplication {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        executor.execute(() -> {

        });
    }
}

package com.lhk.util.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
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

    private static final Logger logger = LoggerFactory.getLogger(ThreadApplication.class);

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");

        List<String> list3 = new ArrayList<>();
        list3.add("5");
        list3.add("6");
        list3.add("7");
        list3.add("8");

        List<String>[] listGroup = new List[2];
        listGroup[0] = list2;
        listGroup[1] = list3;
        executor.execute(() -> {
            for (String str : list) {
                logger.info(str);
                logger.info("size = {}", list.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.warn(e.getMessage(), e);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                logger.info(list.get(i));
                logger.info("size = {}", list.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        });

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                list = listGroup[i % 2];
                try {
                    Thread.sleep(90);
                } catch (InterruptedException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        });
    }
}

package com.lhk.util.app;

/**
 * 2020/12/21 10:03
 *
 * @author deepq_lh
 * @version 1.0.0
 */
public class StringApplication {
    public static void main(String[] args) {
        String testJson = "{\"list\": [{\"id\": \"12311231\"}]}";
        int lastIndex = testJson.lastIndexOf("]", testJson.lastIndexOf("}"));
        int index = testJson.indexOf("[", testJson.indexOf("list"));
        System.out.println(lastIndex + "," + index);
    }
}

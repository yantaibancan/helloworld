package com.iweb.homework.q31;

/**
 * @author yiyu
 * @date 2023/11/25 0:00
 */
public class Test {
    public static void main(String[] args) {
        FakeMap<String,String> fm = new FakeHashMap<>();
        fm.put("jerk","zyn");
        fm.put("jerk","xd");
        fm.put("coldMan","lyh");
        System.out.println(fm.get("jerk"));
        System.out.println(fm.get("coldMan"));
    }
}

package com.iweb.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * java自带线程池
 * @author yiyu
 * @date 2023/11/23 16:06
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
        showSeason(Season.SPRING);

    }

    public static void showSeason(Season season)
    {
        switch (season) {
            case SPRING:
                System.out.println("万物复苏");
                break;
            case SUMMER:
                System.out.println("夏天来了");
                break;
            case AUTUMN:
                System.out.println("秋天来了");
                break;
            case WINTER:
                System.out.println("冬天来了");
                break;
            default:
                System.out.println("输入有误");
                break;

        }
    }
}

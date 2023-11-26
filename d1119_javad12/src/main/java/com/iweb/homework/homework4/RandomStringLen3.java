package com.iweb.homework.homework4;

import java.util.Random;

/**
 * @author yiyu
 * @date 2023/11/20 16:30
 */
public class RandomStringLen3 {
    public static String pool = "zxcvbnmlkjhgfdsaqwertyuiop123654789QWERTYUIOPLKJHGFDSAZXCVBNM";
    static Random random = new Random();
    public static String getStr()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(pool.charAt(random.nextInt(pool.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getStr());
    }
}

package com.iweb.util;

import java.util.Random;

/**
 * @author yiyu
 * @date 2023/11/16 10:45
 */
public class StringUtil {
    private static final String strPool=
            "qwertyuiopasdfghjklzxcvbnm789456123QWERTYUIOPASDFGHJKLZXCVBNM";

    private static final Random r =new Random();

    public static String getCaptchaCode()
    {
        StringBuilder sb=new StringBuilder();
        int count=r.nextInt(3)+4;
        for (int i = 0; i < count; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getCaptchaCode());
    }
}

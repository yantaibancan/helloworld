package com.iweb.homework.asd;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LYH
 * @date 2023/11/20 17:17
 */
public class Test {
    private static final String STR_POOL = "qwertyuiopasdfghjkllzxcvbnm123456789";
    private static final Random r = new Random();
    private volatile static Boolean isOk = new Boolean(false);
    private static List<String> stringList = new ArrayList<String>();
    public static String getCaptchaCode(int num){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(STR_POOL.charAt(r.nextInt(STR_POOL.length())));
        }
        return sb.toString();
    }

    public static void open(int num,String str){
        StringBuilder sb = new StringBuilder();
        sb.append(STR_POOL.charAt(num));
        for(int i=0;i<STR_POOL.length();i++){
            for(int j=0;j<STR_POOL.length();j++){
                sb.append(STR_POOL.charAt(i)).append(STR_POOL.charAt(j));
                synchronized (stringList){
                    if(isOk){
                        return;
                    }
                    stringList.add(sb.toString());
                    // System.out.print(sb+" ");
                    stringList.notify();

                if(sb.toString().equals(str)){
                    System.out.println("\n找到字符串了: "+str);
                    isOk = true;
                    return;
                 }
                }
                sb = new StringBuilder();
                sb.append(STR_POOL.charAt(num));
            }
        }
    }

    public static void main(String[] args) {
        final String str = getCaptchaCode(3);
        System.out.println(str);
        for (int i = 0; i < STR_POOL.length(); i++) {
            final int finalI = i;
            Thread t = new Thread(){
                @Override
                public void run() {
                    open(finalI,str);
                }
            };
            t.start();
        }
        Thread t = new Thread(){
            @Override
            public void run() {
                int count = 0;
                while (count != stringList.size()){
                    synchronized (stringList){
                        if(stringList.get(count) == null){
                            try {
                                stringList.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(stringList.get(count)+" ");
                        count++;
                    }
                }
                System.out.println();
            }
        };
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stringList);
    }

}

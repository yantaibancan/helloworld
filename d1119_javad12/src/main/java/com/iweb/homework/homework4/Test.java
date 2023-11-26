package com.iweb.homework.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/20 16:41
 */
public class Test {
    volatile static List<String> log = new ArrayList<>();
    public static void main(String[] args) {
        String str = RandomStringLen3.getStr();
        System.out.println(str);
        Thread guessStr = new Thread(){
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                loop:for (int i = 0; i < RandomStringLen3.pool.length(); i++) {
                    for (int j = 0; j < RandomStringLen3.pool.length(); j++) {
                        for (int k = 0; k < RandomStringLen3.pool.length(); k++) {
                            sb.append(RandomStringLen3.pool.charAt(i)).append(RandomStringLen3.pool.charAt(j))
                                    .append(RandomStringLen3.pool.charAt(k));
                            synchronized (log)
                            {
                                log.add(sb.toString());
                            }

                            if(sb.toString().equals(str))
                            {
                                break loop;
                            }
                            else
                            {
                                sb.delete(0,sb.length());
                            }
                        }
                    }
                }

                while (true)
                {
                    if(log.isEmpty())
                    {
                        break;
                    }
                }
            }
        };

        Thread logThread = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    if(log.isEmpty())
                    {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        synchronized (log)
                        {
                            System.out.println(log.remove(0));
                        }

                    }
                }
            }
        };
        guessStr.start();
        logThread.setDaemon(true);
        logThread.start();


    }
}

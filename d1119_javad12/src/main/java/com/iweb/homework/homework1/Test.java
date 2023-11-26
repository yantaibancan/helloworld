package com.iweb.homework.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/19 19:39
 */
public class Test {

    public static int getCount(int[] arr)
    {
        for (int i = 0; i < 20; i++) {
            if(arr[i]==0)
            {
                return i;
            }
        }
        return 20;
    }
    public static void main(String[] args) {
        int[] arr = new int[20];
        Object o = new Object();


        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    while (true)
                    {
                        synchronized (o)
                        {

                            if(getCount(arr)<20)
                            {
                                o.notify();
                                int j = getCount(arr);
                                arr[j]=j+1;
                                System.out.println("存入数字"+(j+1)+this.getName());
                                try {
                                    o.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                            if(getCount(arr)==20)
                            {
                                o.notify();
                                try {
                                    o.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }


                            // try {
                            //     Thread.sleep(50);
                            // } catch (InterruptedException e) {
                            //     e.printStackTrace();
                            // }

                        }


                    }
                }
            };
            t.start();;
        }



        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    while (true)
                    {
                       synchronized (o)
                       {


                           if(getCount(arr)>0)
                           {
                               o.notify();
                               int j = getCount(arr);
                               arr[j-1]=0;
                               System.out.println("取出数字"+j+this.getName());
                               try {
                                   o.wait();
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }

                           }
                           if(getCount(arr)==0)
                           {
                               o.notify();
                               try {
                                   o.wait();
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }
                           }



                           // try {
                           //     Thread.sleep(50);
                           // } catch (InterruptedException e) {
                           //     e.printStackTrace();
                           // }
                       }

                    }
                }
            };
            t.start();
        }


    }
}

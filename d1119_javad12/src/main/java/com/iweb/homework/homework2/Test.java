package com.iweb.homework.homework2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author yiyu
 * @date 2023/11/19 21:53
 */
public class Test {
    public static TreeMap<Long, List<File>> tm = new TreeMap<>();
    static final Object o = new Object();

    public  static void listFile(File f,List<Thread> threads)
    {
        synchronized (o)
        {
            if(f.isFile() && f.length()!=0)
            {
                if(!tm.containsKey(f.length()))
                {
                    tm.put(f.length(),new ArrayList<>());
                }
                tm.get(f.length()).add(f);
            }
            else if(f.isDirectory())
            {
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        File[] fs = f.listFiles();
                        for(File file:fs)
                        {
                            listFile(file,threads);
                        }
                    }
                };
                thread.start();
                threads.add(thread);
            }
        }

    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入查找路径");
        String filePath = sc.nextLine();
        File f = new File(filePath);
        if(!f.isDirectory())
        {
            System.out.println("输入有误");
        }
        else
        {
            listFile(f,threads);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for(Thread t:threads)
        {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(tm.size());
        System.out.println("最小文件长度为:"+tm.firstKey()+"对应文件列表为"+tm.firstEntry().getValue());
        System.out.println("最大文件长度为:"+tm.lastKey()+"对应文件列表为"+tm.lastEntry().getValue());
    }

}

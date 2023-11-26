package com.iweb.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/24 22:12
 */
public class Q25 {
    public static void listFile(File file, List<File> files)
    {
        if(file.isFile())
        {
            files.add(file);
        }
        else if(file.isDirectory())
        {
            File[] fs = file.listFiles();
            for (File file1:fs) {
                listFile(file1,files);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\desktop\\experiment");
        List<File> fileList = new ArrayList<>();
        listFile(file,fileList);
        System.out.println(fileList);
    }
}

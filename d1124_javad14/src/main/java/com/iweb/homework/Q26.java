package com.iweb.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author yiyu
 * @date 2023/11/24 22:27
 */
public class Q26 {
    public static void copyFile(File sourceFile, File pasteFile)
    {
        if(sourceFile.isFile())
        {
            String name = sourceFile.getName();
            try(
                    FileInputStream fis = new FileInputStream(sourceFile);
                    FileOutputStream fos = new FileOutputStream(pasteFile+"/"+name)
                    ) {
                byte[] data = new byte[(int) sourceFile.length()];
                fis.read(data);
                fos.write(data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sourceFile.isDirectory()) {
            File[] fs = sourceFile.listFiles();
            String name=sourceFile.getName();
            File newFile = new File(pasteFile+"/"+name);
            newFile.mkdir();
            for (File file:fs) {
                copyFile(file,newFile);
            }
        }
    }

    public static void main(String[] args) {
        File file1 = new File("D:\\desktop\\experiment\\test");
        File file2 = new File("D:\\desktop\\experiment\\tmp");
        copyFile(file1,file2);


    }
}

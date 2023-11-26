package com.iweb.test1;

/**
 * @author yiyu
 * @date 2023/11/19 11:52
 */
public class test {
    public static void main(String[] args) {
        Hercules dls = new Hercules();
        TeacherMa mbg = new TeacherMa();
        mbg.setMarble(dls);
        dls.setDaemon(true);
        mbg.start();
        dls.start();
    }
}

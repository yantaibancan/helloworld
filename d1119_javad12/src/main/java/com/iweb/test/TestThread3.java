package com.iweb.test;

/**线程的优先级  优先级高的线程会有更大的几率竞争到jvm资源
 * 但是 高优先级并不代表绝对 只是相对几率更大
 * 线程的优先级的设置必须在线程进入到就绪态之前
 * @author yiyu
 * @date 2023/11/19 10:27
 */
public class TestThread3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(this.getName());
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(this.getName());
                }
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}

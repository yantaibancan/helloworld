package com.iweb.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/19 13:49
 */
public class Test {
    public static void main(String[] args) {
        TicketShop ticketShop = new TicketShop();
        List<Ikun> littleBlack = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
           Ikun ikun = new Ikun("ikun"+(i+1),ticketShop);
           littleBlack.add(ikun);
        }
        for(Ikun ikun:littleBlack)
        {
            ikun.start();
        }
    }
}

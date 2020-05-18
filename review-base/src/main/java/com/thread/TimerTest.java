package com.thread;

import java.util.Timer;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerDbl(), 2000 * TimerDbl.count);

        //while (true) {
        //    System.out.println(LocalDateTime.now().getSecond());
        //    try {
        //        Thread.sleep(1000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}

    }
}

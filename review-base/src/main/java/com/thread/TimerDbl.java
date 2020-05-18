package com.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDbl extends TimerTask {

    public static volatile int count = 0;

    @Override
    public void run() {
        count = (count + 1) % 2;
        System.out.println("Boob boom");
        (new Timer()).schedule(new TimerDbl(), 2000 + 2000 * count);
    }
}

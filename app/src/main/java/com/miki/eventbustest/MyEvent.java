package com.miki.eventbustest;

/**
 * author：cai_gp on 2019/11/6 19:57
 */
public class MyEvent {
    public final String message;

    public static MyEvent getInstance(String message) {
        return new MyEvent(message);
    }

    private MyEvent(String message) {
        this.message = message;
    }
}

package com.miki.eventbustest;

/**
 * author：cai_gp on 2019/11/6 20:21
 */
public class MyMsg {
    public final String message;

    public static MyMsg getInstance(String message) {
        return new MyMsg(message);
    }

    private MyMsg(String message) {
        this.message = message;
    }
}

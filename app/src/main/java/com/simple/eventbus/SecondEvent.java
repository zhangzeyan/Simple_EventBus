package com.simple.eventbus;

/**
 * Created by zhangzeyan on 16/12/26.
 */

public class SecondEvent {

    private String mMsg;

    public SecondEvent(String msg) {
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}

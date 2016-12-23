package com.simple.eventbus;

/**
 * Created by zhangzeyan on 16/12/23.
 */

public class FirstEvent {

    private String mMsg;

    public FirstEvent(String msg) {
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }

}
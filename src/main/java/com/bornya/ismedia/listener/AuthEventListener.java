package com.bornya.ismedia.listener;

public abstract class AuthEventListener {
    public void onAuthorization(String url){
        System.out.println(url);
    }
}

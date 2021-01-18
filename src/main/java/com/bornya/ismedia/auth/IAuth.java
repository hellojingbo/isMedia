package com.bornya.ismedia.auth;

import com.bornya.ismedia.listener.AuthEventListener;

import java.io.IOException;

public interface IAuth<T>{
    public T authorize(String userName, AuthEventListener listener) throws IOException;
}

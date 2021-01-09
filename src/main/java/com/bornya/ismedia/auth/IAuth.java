package com.bornya.ismedia.auth;

import java.io.IOException;

public interface IAuth<T>{
    public T authorize(String userName) throws IOException;
}

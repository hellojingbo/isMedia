package com.bornya.ismedia.model;

import java.io.Serializable;

public class Proxy implements Serializable {
    String host;
    int port;

    public Proxy(){}
    public Proxy(String host, int port){
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

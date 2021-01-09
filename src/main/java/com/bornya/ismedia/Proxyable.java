package com.bornya.ismedia;

import com.bornya.ismedia.model.Proxy;

public abstract class Proxyable {
    protected void setProxy(Proxy proxy){
        System.out.println("Set the proxy, host=" + proxy.getHost() + ", port=" + proxy.getPort());

        System.setProperty("http.proxyHost", proxy.getHost());
        System.setProperty("http.proxyPort", String.valueOf(proxy.getPort()));

        // 对https也开启代理
        System.setProperty("https.proxyHost", proxy.getHost());
        System.setProperty("https.proxyPort", String.valueOf(proxy.getPort()));
    }
}

package com.bornya.ismedia.auth.oauth2;

import com.bornya.ismedia.listener.AuthEventListener;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;

import java.io.IOException;

public class YoutubeOAuth2App extends AuthorizationCodeInstalledApp {
    AuthEventListener eventListener = new AuthEventListener() {};

    public void setEventListener(AuthEventListener listener){
        this.eventListener = listener;
    }

    public YoutubeOAuth2App(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        super(flow, receiver);
    }

    protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                eventListener.onAuthorization(authorizationUrl.build());
            }
        }).start();
    }
}

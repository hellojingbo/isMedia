package com.bornya.ismedia;

public enum SupportPlatform {
    YOUTUBE("youtube"),
    BILIBILI("bilibili");

    public final String content;

    private SupportPlatform(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}

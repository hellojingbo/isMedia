package com.bornya.ismedia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Video implements Serializable {
    String title;
    String description;

    List<String> tags = new ArrayList<>();
    String privacyStatus;

    String localMediaPath;

    List<RemoteVideoStatus> remoteVideoStatuses = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getPrivacyStatus() {
        return privacyStatus;
    }

    public void setPrivacyStatus(String privacyStatus) {
        this.privacyStatus = privacyStatus;
    }

    public String getLocalMediaPath() {
        return localMediaPath;
    }

    public void setLocalMediaPath(String localMediaPath) {
        this.localMediaPath = localMediaPath;
    }

    public List<RemoteVideoStatus> getRemoteVideoStatuses() {
        return remoteVideoStatuses;
    }

    public void addRemoteVideoStatus(RemoteVideoStatus remoteVideoStatus){
        this.remoteVideoStatuses.add(remoteVideoStatus);
    }
}

package com.bornya.ismedia.upload;

import com.bornya.ismedia.model.Video;

public interface IUploader {
    public Video upload(String userName, Video video);
}

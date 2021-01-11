package com.bornya.ismedia;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bornya.ismedia.auth.IAuth;
import com.bornya.ismedia.auth.YoutubeAuth;
import com.bornya.ismedia.exception.PlatformNotSupportException;
import com.bornya.ismedia.model.Video;
import com.bornya.ismedia.upload.IUploader;
import com.bornya.ismedia.upload.YoutubeUploader;
import com.bornya.ismedia.utils.MD5Utils;
import com.bornya.ismedia.utils.StringUtils;
import com.google.api.client.auth.oauth2.Credential;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTrigger extends Proxyable{
    private static AppTrigger instance;
    private AppTrigger(){}

    public static AppTrigger getInstance(){
        if(instance == null){
            synchronized (AppTrigger.class){
                if(instance == null){
                    instance = new AppTrigger();
                }
            }
        }
        return instance;
    }

    private static final String DEFAULT_USERNAME = "isMedia";


    public void toAuth(String platform, String userName){
        SupportPlatform[] supportPlatforms = SupportPlatform.values();
        SupportPlatform result = Arrays.asList(supportPlatforms).stream()
                .filter(a -> a.getContent().equals(platform))
                .findFirst().orElse(null);

        switch (result){
            case YOUTUBE:
                try{
                    IAuth<Credential> youtubeAuth = new YoutubeAuth();
                    userName = StringUtils.isEmpty(userName) ? DEFAULT_USERNAME : userName;
                    userName = MD5Utils.encrypt16(userName);
                    youtubeAuth.authorize(userName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case BILIBILI:
                System.out.println("Bilibili is being integrated to isMedia...");
                break;
            default:
                throw new PlatformNotSupportException();
        }
    }

    public void toUpload(String platform, String videoInfo, String userName){
        Video video = JSON.parseObject(videoInfo, Video.class);
        SupportPlatform[] supportPlatforms = SupportPlatform.values();
        userName = StringUtils.isEmpty(userName) ? DEFAULT_USERNAME : userName;
        userName = MD5Utils.encrypt16(userName);

        List<SupportPlatform> uploadPlatforms = new ArrayList<>();

        if("all".equals(platform)){
            uploadPlatforms = Arrays.asList(supportPlatforms);
        }else {
            String[] platforms = platform.split(",");
            for(String onePlatform : platforms){
                SupportPlatform result = Arrays.asList(supportPlatforms).stream()
                        .filter(a -> a.getContent().equals(onePlatform))
                        .findFirst().orElse(null);

                uploadPlatforms.add(result);
            }
        }

        for(SupportPlatform uploadPlatform : uploadPlatforms){
            switch (uploadPlatform){
                case YOUTUBE:
                    userName = StringUtils.isEmpty(userName) ? DEFAULT_USERNAME : userName;
                    IUploader youtubeUploader = new YoutubeUploader();
                    youtubeUploader.upload(userName, video);
                    break;
                case BILIBILI:
                    System.out.println("Bilibili is being integrated to isMedia...");
                    break;
                default:
            }
        }
    }
}

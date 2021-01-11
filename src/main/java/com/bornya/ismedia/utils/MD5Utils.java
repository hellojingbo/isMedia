package com.bornya.ismedia.utils;


import org.apache.log4j.Logger;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private static final Logger LOGGER = Logger.getLogger(MD5Utils.class);

    /**
     * 计算32位的MD5值
     * @param str
     * @return
     */
    public static @Nullable String encrypt32(String str){
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e);
            return null;
        }

        byte[] md5Bytes = md5.digest(str.getBytes());
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        str = hexValue.toString();

        return str;
    }

    /**
     * 计算16位的MD5值
     * @param str
     * @return
     */
    public static @Nullable String encrypt16(String str) {
        return encrypt32(str).substring(8, 24);
    }

}

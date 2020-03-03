package io.github.isliqian.tools;

import java.util.Base64;

/**
 * Author:liqian
 * Date:2020/3/3
 * Desc:base64解码
 */
public class Base64Tools {

    /**
     * 字符串加密
     * @param str
     * @return
     */
    public static String encode(String str){
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * 字符串解密
     * @param str
     * @return
     */
    public static String decode(String str){
        byte[] decodedBytes =  Base64.getDecoder().decode(str.getBytes());
        return new String(decodedBytes);
    }

    /**
     * url加密
     * @param url
     * @return
     */
    public static String urlEncode(String url){
        return Base64.getUrlEncoder().encodeToString(url.getBytes());
    }


}

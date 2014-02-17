package com.ru.javaExam.internet;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by 成如 on 13-12-30.
 */
public class UrlDecoderAndUrlEncoder {

    /**
     * URLEncoder将普通字符串转换成application/x-www-form-urlencoded MIME字符串
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test() throws UnsupportedEncodingException {
        String encoder = URLEncoder.encode("南成如","utf-8");
        System.out.println("encoder = " + encoder);
    }

    /**
     * URLDecoder将application/x-www-form-urlencoded MIME字符串转换成普通字符串
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String str = "%E5%8D%97%E6%88%90%E5%A6%82";
        String decoder = URLDecoder.decode(str, "utf-8");
        System.out.println("decoder = " + decoder);
    }
}

package com.ru.javaExam.internet;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 成如 on 13-12-30.
 */
public class UrlTest {
    @Test
    public void test() throws IOException {
        System.out.println("************************************");
        URL url = new URL("http://localhost:80/test?name=ru");
        System.out.println("url的资源名：" + url.getFile());
        System.out.println("url的查询部分：" + url.getQuery());
        System.out.println("url的主机名：" + url.getHost());
        System.out.println("url的端口：" + url.getPort());
        System.out.println("url的协议：" + url.getProtocol());
        System.out.println("url的授权部分：" + url.getAuthority());
//        System.out.println("url的内容：" + url.getContent());

        System.out.println("************************************");
        URL url2 = new URL("https://localhost/test");
        System.out.println("url的默认端口：" + url2.getDefaultPort());
        System.out.println("url的路径部分：" + url2.getPath());
        System.out.println("url的查询部分：" + url2.getQuery());
        System.out.println("url的锚点：" + url2.getRef());
        System.out.println("url的userfo：" + url2.getUserInfo());



    }
}

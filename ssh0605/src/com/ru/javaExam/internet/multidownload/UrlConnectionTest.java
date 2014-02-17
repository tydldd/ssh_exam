package com.ru.javaExam.internet.multidownload;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 成如 on 14-1-1.
 */
public class UrlConnectionTest {
    @Test
    public void test1() throws IOException {
        URL url = new URL("http://s1.bdstatic.com/r/www/cache/eggs/nyear2014/img/default.jpg");
        URLConnection uc = url.openConnection();
        int length = uc.getContentLength();
        System.out.println("长度：" + length);
    }

    @Test
    public void test2(){
        try {
            RandomAccessFile rac = new RandomAccessFile("G:/test/test.tt","rw");
            for (int i = 0; i < 1024; i++){
                rac.write(3);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        int num = 116;
        System.out.println(num/5);
    }
}

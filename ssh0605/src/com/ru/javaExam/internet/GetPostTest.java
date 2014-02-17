package com.ru.javaExam.internet;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by 成如 on 14-1-4.
 */
public class GetPostTest {

    @Test
    public void testGet(){
        BufferedReader br = null;
        String resultStr = null;
        try {
            URL url = new URL("http://www.baidu.com/");
            //打开浏览器和url之间连接
            URLConnection connection = url.openConnection();
            //设置请求头消息
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            //建立实际连接
            connection.connect();
            //获取所有响应消息头
            Map<String,List<String>> map = connection.getHeaderFields();
            for(String key:map.keySet()){
                System.out.println("响应消息头：" + key + "    值：" + map.get(key));
            }

            //定义输入流读取响应的html
            String lineStr = null;
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((lineStr = br.readLine()) != null){
                resultStr = lineStr + "\n";
            }
            System.out.println("输出：" + resultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

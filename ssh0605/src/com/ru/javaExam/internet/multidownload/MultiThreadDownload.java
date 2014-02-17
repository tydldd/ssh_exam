package com.ru.javaExam.internet.multidownload;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;

/**
 * 多线程下载url文件
 * Created by 成如 on 14-1-2.
 */
public class MultiThreadDownload {

    @Test
    public void download(){
        //启动线程数
        int THREAD_NUMBER = 6;
        String filePath = "G:/test/multiThreadDownload.tmp";
        //输入流数组
        InputStream[] inputs = new InputStream[THREAD_NUMBER];
        //输出流数组
        RandomAccessFile[] rafOutputs = new RandomAccessFile[THREAD_NUMBER];

        try{
            URL url = new URL("http://dlsw.baidu.com/sw-search-sp/client2/common/" +
                    "install/2024319335/BaiduAn_Setup_1.1.0.489.exe");
            //每个线程下载的应下载的文件大小，剩余文件大小
            long fileSize =  url.openConnection().getContentLength();
            long averageSize = fileSize / THREAD_NUMBER;
            //剩余大小
            long residueSize = fileSize % THREAD_NUMBER;
            System.out.println("文件大小：" + fileSize + "   剩余文件大小：" + residueSize);
            //创建与下载文件相同大小的临时文件
            inputs[THREAD_NUMBER - 1] = url.openStream();
            rafOutputs[THREAD_NUMBER - 1] = new RandomAccessFile(filePath, "rw");
            for(long i = 0; i < fileSize; i++){
                rafOutputs[THREAD_NUMBER - 1].write(0);
            }

            if(new File(filePath).exists() && rafOutputs[THREAD_NUMBER - 1].length() == fileSize){
                System.out.println("创建临时文件完成");
            }

            //创建输入输出输出流，并启动线程
            for(int x = 0; x < THREAD_NUMBER; x++){
                if (x < THREAD_NUMBER - 1){
                    inputs[x] = url.openStream();
                    rafOutputs[x] = new RandomAccessFile(filePath, "rw");
                    Runnable thread = new DownloadThread(x * averageSize, (x + 1) * averageSize,
                            inputs[x], rafOutputs[x]);
                    new Thread(thread, "线程" + x).start();
                    System.out.println("启动线程" + x);
                }else {
                    Runnable thread = new DownloadThread(x * averageSize, (x + 1) * averageSize + residueSize,
                            inputs[x], rafOutputs[x]);
                    new Thread(thread, "线程" + x).start();
                    System.out.println("启动线程" + x);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

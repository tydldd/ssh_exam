package com.ru.javaExam.internet.multidownload;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * 多线程下载文件线程
 * Created by 成如 on 14-1-1.
 */
public class DownloadThread implements Runnable{
    private int BUFFERLEN = 1024;
    //读取和写入文件的开始指针
    private long start;
    //读取和写入文件的结束指针
    private long end;
    //输入流
    private InputStream inputStream;
    //输出流
    private RandomAccessFile rafOutput;

    public DownloadThread(long start, long end, InputStream inputStream, RandomAccessFile rafOutput) {
        this.start = start;
        this.end = end;
        this.inputStream = inputStream;
        this.rafOutput = rafOutput;
    }

    @Override
    public void run() {
        try {
            //设置输入流指针开始位置
            inputStream.skip(start);
            //设置输出流指针开始位置
            rafOutput.seek(start);

            //读取次数
            long times = 0;
            //实际读取的字节数
            int hasRead = 0;
            byte[] buffer = new byte[BUFFERLEN];
            if((end - start) % BUFFERLEN == 0){
                times = (end - start) / BUFFERLEN;
            }else{
                times = (end -start) /BUFFERLEN + 1;
            }

            //读取文件
            for (int i = 0; i < times; i++){
                hasRead = inputStream.read(buffer);
                if(hasRead > 0){
                    rafOutput.write(buffer, 0, hasRead);
                }else{
                    break;
                }
            }

            System.out.println("下载操作执行完成");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rafOutput != null){
                    rafOutput.close();
                }
                if (inputStream != null){
                    inputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

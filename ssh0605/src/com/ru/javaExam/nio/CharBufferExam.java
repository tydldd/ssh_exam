package com.ru.javaExam.nio;

import com.ru.javaExam.util.EnumPath;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.util.SystemOutLogger;

import java.nio.CharBuffer;

/**
 * Description:    新io流字符缓冲区例子
 * User: NanChengRu
 * Date: 13-11-11
 * Time: 上午10:14
 * JDK: 1.6
 * version: 1.0
 */
public class CharBufferExam {
    private static Logger log = Logger.getLogger(CharBufferExam.class);

    static{
        PropertyConfigurator.configure(EnumPath.LOG4J.getPath());
    }

    public static void main(String[] args){
        CharBuffer cb = CharBuffer.allocate(10);

        System.out.println("字符缓冲区的容量位置：" + cb.capacity());
        System.out.println("字符缓冲区的limit限制位置：" + cb.limit());
        System.out.println("字符缓冲区的position指针位置：" + cb.position());

        //放入字符
        cb.put('a');
        cb.put('b');
        cb.put('c');
        System.out.println("字符缓冲区的limit限制位置：" + cb.limit());
        System.out.println("字符缓冲区的position指针位置：" + cb.position());

        //使用flip方法将limit置为当前position位置，将指针position归零
        cb.flip();
        System.out.println("字符缓冲区的limit限制位置：" + cb.limit());
        System.out.println("字符缓冲区的position指针位置：" + cb.position());
        //取出第一个字符
        char first = cb.get();
        System.out.println("取出的第一个字符：" + Character.toString(first));
        System.out.println("字符缓冲区的limit限制位置：" + cb.limit());
        System.out.println("字符缓冲区的position指针位置：" + cb.position());

        //清除此缓冲区，position置为0，限制置为容量，丢弃标记
        cb.clear();
        System.out.println("字符缓冲区的limit限制位置：" + cb.limit());
        System.out.println("字符缓冲区的position指针位置：" + cb.position());
        System.out.println("abc22222");
    }
}

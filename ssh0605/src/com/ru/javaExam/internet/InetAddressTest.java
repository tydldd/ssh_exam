package com.ru.javaExam.internet;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by 成如 on 13-12-29.
 */
public class InetAddressTest {
    @Test
    public void test() throws Exception {
        //得到ip的两种方式
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("IP = " + ip);
        System.out.println("是否可以到达www.baidu.com :" + ip.isReachable(1000));
        System.out.println("ip的全限定域名：" + ip.getCanonicalHostName());
        System.out.println("ip地址：" + ip.getHostAddress() + "    ip主机名：" + ip.getHostName());

        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("本地地址：" + local);
        System.out.println("是否可以到达local :" + local.isReachable(1000));
    }
}

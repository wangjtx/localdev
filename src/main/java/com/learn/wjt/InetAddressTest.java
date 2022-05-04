package com.learn.wjt;

import org.junit.Test;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @Author wangjintao
 * @Description 功能描述
 * @Version 1.0
 * @Date 2022/5/1 11:43
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress allByName = InetAddress.getByName("www.baidu.com");
            System.out.println(allByName);
            System.out.println(allByName.getHostName());
            System.out.println(allByName.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    // 客户端
    public void myClient(){
        try {
            InetAddress ip = InetAddress.getByName("192.168.0.1");
            Socket socket = new Socket(ip,9011);
            OutputStream os = socket.getOutputStream();
            os.write("hello,i is client".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 服务器
    public void myServer(){

    }
}

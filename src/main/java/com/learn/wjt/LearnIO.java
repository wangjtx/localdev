package com.learn.wjt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Author wangjintao
 * @Description 学习IO流的使用
 * @Version 1.0
 * @Date 2022/4/25 22:17
 */
public class LearnIO {
    /**
     * 一丶流的分类
     * 1.操作数据单位: 字节流(处理视频图片文件) 字符流(处理文本文件)
     *  使用字节流处理文本文件可能会乱码
     * 2.数据流的方向: 输入流 输出流
     * 3.流的角色: 节点流 处理流(包装流)
     * 二丶 流的体系结构
     * 抽象基类          节点流(文件流)       缓冲流(处理流的一种)
     * InputStream    FileInputStream      BufferedInputStream
     * OutputStream   FileOutputStream     BufferedOutputStream
     * Reader         FileReader           BufferedReader
     * Writer         FileWriter           BufferedWriter
     */
    public static void main(String[] args) throws Exception {
        File file = new File("Hello.txt");
        File writerFile = new File("Hi.txt");
        System.out.println("文件的绝对路径-----------" + file.getAbsolutePath());
        FileReader fileReader = new FileReader(file);
        // new FileWriter(file,true)  写入数据不会对源文件进行覆盖,而是在文件后追加文件
        // new FileWriter(writerFile,false)/new FileWriter(writerFile)  文件存在会覆盖源文件
        FileWriter fileWriter = new FileWriter(writerFile,true);
        char[] chars = new char[5];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            String string = new String(chars, 0, len);
            System.out.print(string);
            fileWriter.write(chars,0,len);
            fileWriter.flush();
        }
        fileReader.close();
        fileWriter.close();
    }
}

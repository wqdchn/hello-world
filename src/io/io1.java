package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: hello-world
 * @description: 字节流
 * @author: wqdong
 * @create: 2020-02-22 10:29
 **/
public class io1 {

  public static void main(String[] args) {

    int c = 0;
    FileInputStream in = null;
    try {
      in = new FileInputStream("F:\\IO.txt");
    } catch (FileNotFoundException e) {
      System.out.println("没有该文件");
    }

    int len = 0;
    try {
      while ((c = in.read()) != -1) {
        System.out.print((char) c + " ");
        len++;
      }
      in.close();
      System.out.println();
      System.out.print("读取了" + len + "字节");
    } catch (IOException e) {
      System.out.println("读取出错");
    }

    FileOutputStream out = null;
    try {
      in = new FileInputStream("F:\\IO.txt");
      out = new FileOutputStream("F:\\IO1.txt");

      while ((c = in.read()) != -1) {
        out.write(c);
      }

      in.close();
      out.close();
      System.out.println("写入完成");

    } catch (FileNotFoundException e) {
      System.out.println("没有该文件");
    } catch (IOException e) {
      System.out.println("读取出错");
    }


  }

}

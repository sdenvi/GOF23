package com.sdenvi.gof24.Decorator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/**
 * Created by IntelliJ IDEA.
 * User: someone
 * Date:2018/12/21
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class IOTest {
    /** test.txt内容：
     * hello world!
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //文件路径可自行更换
        final String filePath = "E:/test.txt";

        // InputStream相当于被装饰的接口或者抽象类，FileInputStream相当于原始的待装饰的对象，FileInputStream无法装饰InputStream
        // 另外FileInputStream是以只读方式打开了一个文件,并打开了一个文件的句柄存放在FileDescriptor对象的handle属性
        // 所以下面有关回退和重新标记等操作，都是在堆中建立缓冲区所造成的假象,并不是真正的文件流在回退或者重新标记
        InputStream inputStream = new FileInputStream(filePath);
        // 记录一下流的长度
        final int len = inputStream.available();
        System.out.println("FileInputStream不支持mark和reset：" + inputStream.markSupported());

        System.out.println("---------------------------------------------------------------------------------");

        // 下面分别展示三种装饰器的作用BufferedInputStream,DataInputStream,PushbackInputStream,下面做了三个装饰器的功能演示

        // 首先装饰成BufferedInputStream，它提供我们mark，reset的功能
        // 装饰成 BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        System.out.println("BufferedInputStream支持mark和reset：" + bufferedInputStream.markSupported());
        // 标记一下
        bufferedInputStream.mark(0);
        char c = (char) bufferedInputStream.read();
        System.out.println("文件的第一个字符：" + c);
        // 重置
        bufferedInputStream.reset();
        // 再读
        c = (char) bufferedInputStream.read();
        System.out.println("重置以后再读一个字符，依然会是第一个字符:" + c);
        bufferedInputStream.reset();

        System.out.println("---------------------------------------------------------------------------------");

        //装饰成 DataInputStream,我们为了使用DataInputStream,又使用BufferedInputStream的mark reset功能，所以我们再进行一层包装
        //注意，这里如果不使用BufferedInputStream，而使用原始的InputStream，read方法返回的结果会是-1，即已经读取结束
        //因为BufferedInputStream已经将文本的内容读取完毕，并缓冲到堆上，默认的初始缓冲区大小是8192B
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        //这是BufferedInputStream提供的功能，如果不在这个基础上包装会出错
        dataInputStream.reset();
        System.out.println("DataInputStream现在具有readInt，readChar,readUTF等功能");
        //读出来一个int,包含四个字节
        int value = dataInputStream.readInt();
        //我们转换成字符依次显示出来，可以看到文件的前四个字符
        String binary = Integer.toBinaryString(value);
        int first = binary.length() % 8;
        System.out.print("使用readInt读取的前四个字符：");
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.print(((char)Integer.valueOf(binary.substring(0, first), 2).intValue()));
            }else {
                System.out.print(((char)Integer.valueOf(binary.substring(( i - 1 ) * 8 + first, i * 8 + first), 2).intValue()));
            }
        }
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------");

        //PushbackInputStream无法包装BufferedInputStream支持mark reset，因为它覆盖了reset和mark方法
        //因为流已经被读取到末尾，所以我们必须重新打开一个文件的句柄，即FileInputStream
        inputStream = new FileInputStream(filePath);
        //装饰成 PushbackInputStream
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream,len);
        System.out.println("PushbackInputStream装饰以后支持退回操作unread");
        byte[] bytes = new byte[len];
        //读完了整个流
        pushbackInputStream.read(bytes);
        System.out.println("unread回退前的内容：" + new String(bytes));
        //再退回去
        pushbackInputStream.unread(bytes);
        //清空byte数组
        bytes = new byte[len];
        //再读
        pushbackInputStream.read(bytes);
        System.out.println("unread回退后的内容：" + new String(bytes));

        System.out.println("---------------------------------------------------------------------------------");

        /*  以上有两个一层装饰和一个两层装饰,下面我们先装饰成Reader，再进行其它装饰   */

        //由于之前被PushbackInputStream将流读取到末尾，我们需要再次重新打开文件句柄
        inputStream = new FileInputStream(filePath);
        //先装饰成InputStreamReader
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
        System.out.println("InputStreamReader有reader的功能，比如转码：" + inputStreamReader.getEncoding());

        System.out.println("---------------------------------------------------------------------------------");

        //我们进一步在reader的基础上装饰成BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("BufferedReader有readLine等功能：" + bufferedReader.readLine());

        System.out.println("---------------------------------------------------------------------------------");

        //我们进一步在reader的基础上装饰成LineNumberReader
        LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
        System.out.println("LineNumberReader有设置行号，获取行号等功能（行号从0开始）,当前行号：" + lineNumberReader.getLineNumber());

        System.out.println("---------------------------------------------------------------------------------");

        //此处由于刚才被readLine方法将流读取到末尾,所以我们再次重新打开文件句柄,并需要将inputstream再次包装成reader
        inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        //我们进一步在reader的基础上装饰成PushbackReader
        PushbackReader pushbackReader = new PushbackReader(inputStreamReader,len);
        System.out.println("PushbackReader是拥有退回操作的reader对象");
        char[] chars = new char[len];
        pushbackReader.read(chars);
        System.out.println("unread回退前的内容：" + new String(chars));
        //再退回去
        pushbackReader.unread(chars);
        //清空char数组
        chars = new char[len];
        //再读
        pushbackReader.read(chars);
        System.out.println("unread回退后的内容：" + new String(chars));
    }
}

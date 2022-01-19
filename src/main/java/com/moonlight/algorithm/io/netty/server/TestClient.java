package com.moonlight.algorithm.io.netty.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author Moonlight
 */
public class TestClient {

    public static void main(String[] args) throws IOException {
        SocketChannel open = SocketChannel.open(new InetSocketAddress("localhost", 8081));

        int cnt = 1;
        String message = "";
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equals(message)) {
            System.out.println("请输入" + cnt + ": ");
            message = scanner.nextLine() + "\r\n";
            open.write(ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8)));
            cnt++;
        }
        open.close();
    }

}
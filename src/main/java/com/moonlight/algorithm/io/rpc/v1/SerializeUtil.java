package com.moonlight.algorithm.io.rpc.v1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @ClassName SerializUtil
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/11/16 22:34
 * @Version V1.0
 **/
public class SerializeUtil {
    static ByteArrayOutputStream out = new ByteArrayOutputStream();

    public synchronized static byte[] out(Object msg) {
        out.reset();
        ObjectOutputStream outputStream;
        byte[] msgBody = null;
        try {
            outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(msg);
            msgBody = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msgBody;
    }

}

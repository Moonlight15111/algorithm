package com.moonlight.algorithm.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName LogConsole
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/21 15:47
 * @Version V1.0
 **/
public class LogConsole {

    public static void main (String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        ExecutorService service = Executors.newCachedThreadPool();
        long begin = System.currentTimeMillis();
        System.out.println("begin:"+begin);
        for (int i = 0; i < 4; i++)  {
            Runnable runnable = () -> {
                try {
                    while (true) {
                        LogConsole.parseLog(queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.submit(runnable);
        }
        for (int i = 0; i < 16; i++) {
            final String log = "" + (i + 1);
            queue.put(log);
        }
        long end = System.currentTimeMillis();
        System.out.println("花费 " + (end - begin) / 1000 + "s");
    }

    public static void parseLog(String log){
        System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

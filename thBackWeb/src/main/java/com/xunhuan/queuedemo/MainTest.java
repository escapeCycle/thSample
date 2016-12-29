package com.xunhuan.queuedemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * Created by escapeCycle on 2016/12/21.
 */
public class MainTest {

    public MainTest() throws IOException, TimeoutException {
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");

        for (int i = 0; i < 10000; i++) {

            HashMap message = new HashMap();
            message.put("message number",i);
            producer.sendMessage(message);
            System.out.println("Message Number "+i+" sent");
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
//        new MainTest();

        Producer producer = new Producer("queue");

        for (int i = 0; i < 10000; i++) {

            HashMap message = new HashMap();
            message.put("message number",i);
            producer.sendMessage(message);
            System.out.println("Message Number "+i+" sent");
        }
    }

}

package com.xunhuan.queue;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by escapeCycle on 2016/12/19.
 */
@Component
public class RabbitmqListener {

    // 在注解中可以指定用哪个工厂, 工厂可以配置线程数
    @RabbitListener(queues = "myqueue", containerFactory = "rabbitListenerContainerFactory")
    public void processOrder(Message message) throws InterruptedException {
        System.out.println("testtesttest");
        System.out.println(new String(message.getBody()) + "\t" + Thread.currentThread().getId());
        Thread.sleep(3000);
    }

    @RabbitListener(queues = "myqueue2")
    public void processOrder2(Message message) throws InterruptedException {
        System.out.println(new String(message.getBody()) + "\t" + Thread.currentThread().getId());
        Thread.sleep(3000);
    }

    //    @RabbitListener(queues = "handle.bidRecord.queue")
    public void processHandleBidRecord(Message message) throws InterruptedException {
        System.out.println(new String(message.getBody()) + "\t" + Thread.currentThread().getId());
//        Thread.sleep(3000);
    }
}

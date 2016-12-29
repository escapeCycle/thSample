package com.xunhuan.queuedemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产和消费者共用
 * Created by escapeCycle on 2016/12/21.
 */
public abstract class EndPoint {

    protected Channel channel;

    protected Connection connection;

    protected String endPointName;

    public EndPoint(String endPointName) throws IOException,TimeoutException {

        this.endPointName = endPointName;

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("10.55.255.103");

        factory.setUsername("root");
        factory.setPassword("root");

        connection = factory.newConnection();

        channel = connection.createChannel();

        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(endPointName, false, false, false, null);
    }

    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     */
    public void close() throws IOException,TimeoutException {
        this.channel.close();
        this.connection.close();
    }

}

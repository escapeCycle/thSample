package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by escapeCycle on 2016/12/19.
 */
public class TestReceive {

    private final static String QUEUE_NAME = "myqueue2";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.55.255.103");
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        boolean autoAck = false;
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                // (process the message components here ...)
                channel.basicAck(deliveryTag, false);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}

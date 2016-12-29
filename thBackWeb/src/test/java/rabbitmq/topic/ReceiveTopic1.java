package rabbitmq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by escapeCycle on 2016/12/27.
 */
public class ReceiveTopic1 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) {
        Connection conn = null;
        Channel channel = null;

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("10.55.255.103");
            factory.setUsername("root");
            factory.setPassword("root");
            conn = factory.newConnection();
            channel = conn.createChannel();
            //声明匹配式交换器
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();
            //路由关键字
            String[] routingKeys = new String[]{"*.orange.*"};
            //绑定路由关键字
            for (String str : routingKeys) {
                channel.queueBind(queueName, EXCHANGE_NAME, str);
                System.out.println("ReceiveLogsTopic1 exchange:" + EXCHANGE_NAME + ", queue:" + queueName + ", BindRoutingKey:" + str);
            }
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body,"UTF-8");
                    System.out.println("ReceiveLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                }
            };
            channel.basicConsume(queueName,true,consumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}

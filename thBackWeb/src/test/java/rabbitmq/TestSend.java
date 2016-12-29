package rabbitmq;

import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by escapeCycle on 2016/12/19.
 */
public class TestSend {

    private final static String QUEUE_NAME = "myqueue2";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.55.255.103");
        factory.setUsername("root");
        factory.setPassword("root");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, new AMQP.BasicProperties.Builder().deliveryMode(2).build(), message.getBytes());
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, "Hello World2!".getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","nihao");
        map.put("key2","buhao");
        map.forEach((key,value)->{
            if(key.startsWith("-D")){
                System.setProperty(key.substring(2),value);
            }
        });
    }
}

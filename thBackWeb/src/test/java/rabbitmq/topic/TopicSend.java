package rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by escapeCycle on 2016/12/27.
 */
public class TopicSend {

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

            //匹配模式交换器
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            String[] routingKeys = new String[]{"quick.orange.rabbit",
                    "lazy.orange.elephant",
                    "quick.orange.fox",
                    "lazy.brown.fox",
                    "quick.brown.fox",
                    "quick.orange.male.rabbit",
                    "lazy.orange.male.rabbit"};
            //发送消息
            for (String str : routingKeys ){
                String message = "From " + str + "routingKey's message";
                channel.basicPublish(EXCHANGE_NAME,str,null,message.getBytes());
                System.out.println("TopicSend [x] Sent '" + str + "':'" + message + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {

                }
            }
        }

    }

}

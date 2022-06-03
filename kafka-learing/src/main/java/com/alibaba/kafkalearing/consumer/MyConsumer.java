package com.alibaba.kafkalearing.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/2
 * @Description:
 */

/**
 * @Component （把普通pojo，实例化到spring容器中，相当于配置文件中的 ）
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），
 * 我们就可以使用@Component来标注这个类。
 */

@Configuration
public class MyConsumer {

//    监听指定topics中的消息，并对消息进行处理
    @KafkaListener(topics = "topic-spring-01")
    public void onMessage(ConsumerRecord<Integer, String> record){
        System.out.println("消费者收到的消息："
                + record.topic() + "   "
                + record.partition() + "   "
                + record.offset() + "   "
                + record.key() + "   "
                + record.value()
                );
    }
}

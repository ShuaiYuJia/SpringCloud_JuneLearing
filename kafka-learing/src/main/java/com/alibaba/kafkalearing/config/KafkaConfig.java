package com.alibaba.kafkalearing.config;

import org.apache.kafka.clients.admin.NewPartitionReassignment;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/3
 * @Description: kafka配置类
 */

/**
 * Bean注解的作用之一就是能够管理第三方jar包内的类到容器中。
 * 现在我们引入一个第三方的jar包，这其中的某个类，StringUtil需要注入到我们的IndexService类中，
 * 因为我们没有源码，不能再StringUtil中增加@Component或者@Service注解。
 * 这时候我们可以通过使用@Bean的方式，把这个类交到Spring容器进行管理，
 * 最终就能够被注入到IndexService实例中。
 *
 * 在@Configuration中被@Bean标记的方法，会被Spring进行CGLIB代理，从而进行增强。
 */

/**
 * 此处，使用下面两个注解都可以，刚才视频老师说，作用是保证当前类能够被扫描到
 * @Configuration
 * @Component
 */
@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic1(){
        return new NewTopic("nptc-01", 3, (short) 1);
    }

    @Bean
    public NewTopic topic2(){
        return new NewTopic("nptc-02", 5, (short) 1);
    }
}

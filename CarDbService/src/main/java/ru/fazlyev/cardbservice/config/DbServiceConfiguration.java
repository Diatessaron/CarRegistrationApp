package ru.fazlyev.cardbservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbServiceConfiguration {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("car.exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("car.queue");
    }

    @Bean
    public Binding binding(DirectExchange directExchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with("car");
    }

    @Bean
    public MessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

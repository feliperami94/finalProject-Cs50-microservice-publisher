package com.santiagoposadag.cs50.receiverpublisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQConfig Queue and routing keys
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
public class RabbitMQConfig {

    public static final String GENERAL_QUEUE = "action.general";
    public static final String SELL_QUEUE = "action.sell";
    public static final String BUY_QUEUE = "action.buy";
    public static final String USER_QUEUE = "action.user";

    public static final String EXCHANGE = "actions_exchange";

    public static final String GENERAL_ROUTING_KEY = "routingKey.*";
    public static final String SELL_ROUTING_KEY = "routingKey.sell";
    public static final String BUY_ROUTING_KEY = "routingKey.buy";
    public static final String USER_ROUTING_KEY = "routingKey.user";

    @Bean
    public Queue getGeneralQueue() {
        return new Queue(GENERAL_QUEUE, true);
    }

    @Bean
    public Queue getSellQueue() {
        return new Queue(SELL_QUEUE);
    }

    @Bean
    public Queue getBuyQueue() {
        return new Queue(BUY_QUEUE);
    }

    @Bean
    public Queue getUserQueue() {
        return new Queue(USER_QUEUE);
    }

    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding BindingToGeneralQueue() {
        return BindingBuilder.bind(getGeneralQueue()).to(getTopicExchange()).with(GENERAL_ROUTING_KEY);
    }

    @Bean
    public Binding BindingToSellQueue() {
        return BindingBuilder.bind(getSellQueue()).to(getTopicExchange()).with(SELL_ROUTING_KEY);
    }

    @Bean
    public Binding BindingToBuyQueue() {
        return BindingBuilder.bind(getBuyQueue()).to(getTopicExchange()).with(BUY_ROUTING_KEY);
    }

    @Bean
    public Binding BindingToUserQueue() {
        return BindingBuilder.bind(getUserQueue()).to(getTopicExchange()).with(USER_ROUTING_KEY);
    }
}

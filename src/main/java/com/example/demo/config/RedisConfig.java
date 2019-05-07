package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfig {

    @Autowired
    private ClusterConfigurationProperties clusterConfigurationProperties;
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        return new JedisConnectionFactory(
                new RedisClusterConfiguration(clusterConfigurationProperties.getNodes())
        );
    }

}

package com.redisdemo.configs;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/*
 * @author Jeff
 * @date 9/10/21 2:35 PM
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

}

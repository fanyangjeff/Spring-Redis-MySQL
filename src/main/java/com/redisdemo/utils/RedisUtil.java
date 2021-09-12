package com.redisdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/*
 * @author Jeff
 * @date 9/10/21 2:28 PM
 */
@Component
public class RedisUtil {
    private final static int ExpireTime = 60;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(@Autowired RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set (String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value, ExpireTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object get (String key) {
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            return operations.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Object();
    }

    public boolean delete (String key) {
        try {
            if (!this.hasKey(key)) {
                return false;
            }
            redisTemplate.delete(key);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

package com.redisdemo.controller;

import com.redisdemo.entity.Student;
import com.redisdemo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Jeff
 * @date 9/10/21 3:43 PM
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/set/{uid}/{name}")
    public boolean redisSet(@PathVariable String uid, @PathVariable String name) {

        redisUtil.set(uid, new Student(name, uid));
        return true;
    }


    @PostMapping("setAll")
    public void redisSetAll() {
        List<Object> list = new ArrayList<>();
        list.add(new Student("Jeff", "123"));
        list.add(new Student("Emily", "222"));

        redisUtil.set("list", list);

    }

    @GetMapping("/get/{uid}")
    public Object redisGet(@PathVariable String uid) {
        return redisUtil.get(uid);
    }

    @DeleteMapping("/delete/{uid}")
    public boolean redisDelete(@PathVariable String uid) {
        return redisUtil.delete(uid);
    }
}

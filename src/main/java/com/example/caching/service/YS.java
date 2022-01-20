package com.example.caching.service;

import com.example.caching.model.Y;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class YS {
    private ArrayBlockingQueue<Y> queue;

    @PostConstruct
    public void init() {
        queue = new ArrayBlockingQueue<>(10);
    }

    public ArrayBlockingQueue<Y> findAll() {
        return queue;
    }

    public boolean add(Y y) {
        return queue.offer(y);
    }

    public Y poll() {
        return queue.poll();
    }
}

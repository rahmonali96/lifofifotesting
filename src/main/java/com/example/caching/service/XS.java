package com.example.caching.service;

import com.example.caching.model.X;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class XS {
    private Stack<X> queue;

    @PostConstruct
    public void init() {
        queue = new Stack<>();
    }

    public Stack<X> findAll() {
        return queue;
    }

    public X push(X x){
        return queue.push(x);
    }

    public X pop() {
        return queue.pop();
    }

    public X peek() {
        return queue.peek();
    }

    public int capacity() {
        return queue.size();
    }

}

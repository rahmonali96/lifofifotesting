package com.example.caching.controller;

import com.example.caching.model.Y;
import com.example.caching.service.YS;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ArrayBlockingQueue;

@RestController
@AllArgsConstructor
@RequestMapping("/queue")
public class YC {
    private YS ys;

    @GetMapping("/all")
    public ResponseEntity<ArrayBlockingQueue<Y>> getAll() {
        return new ResponseEntity<>(ys.findAll(), HttpStatus.OK);
    }

    @PostMapping("/offer")
    public ResponseEntity<?> offer(@RequestBody Y y) {
        return new ResponseEntity<>(ys.add(y), HttpStatus.OK);
    }

    @GetMapping("/poll")
    public ResponseEntity<Y> poll() {
        return new ResponseEntity<>(ys.poll(), HttpStatus.OK);
    }
}

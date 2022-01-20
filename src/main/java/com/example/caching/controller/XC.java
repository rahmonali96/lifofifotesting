package com.example.caching.controller;

import com.example.caching.model.X;
import com.example.caching.service.XS;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@RestController
@AllArgsConstructor
@RequestMapping("/stack")
public class XC {
    private XS xs;

    @GetMapping("/all")
    public ResponseEntity<Stack<X>> getAll() {
        return new ResponseEntity<>(xs.findAll(), HttpStatus.OK);
    }

    @PostMapping("/push")
    public ResponseEntity<?> push(@RequestBody X x) {
        return new ResponseEntity<>(xs.push(x), HttpStatus.OK);
    }

    @DeleteMapping("/pop")
    public ResponseEntity<X> pop() {
        return new ResponseEntity<>(xs.pop(), HttpStatus.OK);
    }

    @PostMapping("/peek")
    public ResponseEntity<X> peek() {
        return new ResponseEntity<>(xs.peek(), HttpStatus.OK);
    }

    @GetMapping("/remain")
    public ResponseEntity<?> remainingCapacity() {
        return new ResponseEntity<>(xs.capacity(), HttpStatus.OK);
    }

}

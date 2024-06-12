package me.jamieburns.springbootquicksort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.jamieburns.springbootquicksort.service.QuicksortService;

@RestController
public class QuicksortController {

    @Autowired
    private QuicksortService quicksortService;

    @PostMapping("/quicksort")
    List<Integer> quicksort(@RequestBody List<Integer> list) {
        return quicksortService.quicksort(list);
    }
}

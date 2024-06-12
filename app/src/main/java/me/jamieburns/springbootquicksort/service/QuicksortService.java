package me.jamieburns.springbootquicksort.service;

import java.util.List;

import org.springframework.stereotype.Service;
import me.jamieburns.structures.quicksort.Quicksort;

@Service
public class QuicksortService {

    public List<Integer> quicksort(List<Integer> list) {
        return new Quicksort(list).sort();
    }
}

package me.jamieburns.springbootquicksort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import me.jamieburns.springbootquicksort.service.QuicksortService;

@RestController
public class QuicksortController {

    @Autowired
    private QuicksortService quicksortService;

    //@CrossOrigin(origins = "http://localhost:3000", maxAge = 300)
    @PostMapping("/quicksort")
    List<Integer> quicksort(@RequestBody List<Integer> list) {
        return quicksortService.quicksort(list);
    }
}

@Configuration
class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/quicksort")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST")
                .maxAge( 300 );
    }
}

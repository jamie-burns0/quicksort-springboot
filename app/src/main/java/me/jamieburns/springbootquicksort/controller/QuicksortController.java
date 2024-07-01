package me.jamieburns.springbootquicksort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Stream;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import me.jamieburns.springbootquicksort.service.QuicksortService;

@RestController
public class QuicksortController {

    @Autowired
    private QuicksortService quicksortService;

    @PostMapping( {"/quicksort", "/prod/quicksort"})
    List<Integer> quicksort(@RequestBody List<Integer> list) {
        return quicksortService.quicksort(list);
    }
}

@Configuration
class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        Stream.of( "/quicksort", "/prod/quicksort" )
            .forEach( path -> {
                registry.addMapping( path )
                        .allowedOriginPatterns("http://localhost:3000", "http://app.jamieburns.me:3000")
                        .allowedMethods("POST")
                        .maxAge( 300 );
            } );
    }
}

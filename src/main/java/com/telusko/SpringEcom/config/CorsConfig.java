/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telusko.SpringEcom.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author yadav
 */
@Configuration
public class CorsConfig {
    @Bean
public CorsFilter corsFilter() {

    CorsConfiguration config = new CorsConfiguration();

    config.setAllowedOrigins(Arrays.asList(
            "http://localhost:3000",
            "http://localhost:5173"
    ));

    config.setAllowedMethods(Arrays.asList(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
    ));

    config.setAllowedHeaders(Arrays.asList("*"));

    config.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
}
}

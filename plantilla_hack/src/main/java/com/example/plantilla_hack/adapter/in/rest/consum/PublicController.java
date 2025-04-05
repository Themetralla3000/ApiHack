package com.example.plantilla_hack.adapter.in.rest.consum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }
}
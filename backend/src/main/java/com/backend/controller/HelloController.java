package com.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    //restservice
    @GetMapping("simple")
    public String simpleHello(){
        return "Hola mundo";
    }

    @GetMapping(value = "custom/{name}")
    public String custom(@PathVariable String name){
        return "Hello "+name;
    }

    @GetMapping(value = "custom")
    public String custom2(@RequestParam String name){
        return "Hello "+name;
    }
}

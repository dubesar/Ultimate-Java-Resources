package com.kshitij.cms.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Entry {

    @RequestMapping(value = "/hello")
    public String greetings() {
        return "Hey there! Welcome to Spring!";
    }
}

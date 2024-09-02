package ru.pilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pilot.service.EurekaClient;

@RestController
@RequestMapping("")
public class EurekaController {

    @Autowired
    private EurekaClient greetingClient;


    @GetMapping("/greeting")
    public String demo2() {
        return  greetingClient.greeting();
    }


}

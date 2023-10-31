package br.inatel.labs.labrest_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public MyMessage processarGetHello(){
        MyMessage msg = new MyMessage();
        msg.setInfo("Olá, mundo Rest");
        return msg;
    }

}

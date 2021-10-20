package org.zensar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zensar.model.ResponseModel;

@RestController
public class HelloController {

    @Value("${host.name}")
    String hostname;

    @GetMapping("/hello")
    public ResponseModel helloWorld(@RequestParam( value = "name", required = true) String name){

        String message = "Hello, "+name+"! I am "+hostname;

        ResponseModel responseModel = new ResponseModel(message);
        return  responseModel;
    }

    //Message should return - Hello, <name>!  I am <host>


    @GetMapping("/hi")
    public String hello(){
        return "hello";
    }
}

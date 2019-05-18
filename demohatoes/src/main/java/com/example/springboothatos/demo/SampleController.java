package com.example.springboothatos.demo;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public Resource<Hello> hello(){
        Hello hello = new Hello();
        hello.setName("hello");
        hello.setPrefix("keesun");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());
        return helloResource;
    }
}

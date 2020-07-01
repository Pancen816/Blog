package com.brucer.web.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class TypesController {

    @GetMapping("/types")
    public String types () {

        return "blog/types";
    }

}

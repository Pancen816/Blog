package com.brucer.web.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class ArchivesController {

    @GetMapping("/archives")
    public String archives () {

        return "blog/archives";
    }

}

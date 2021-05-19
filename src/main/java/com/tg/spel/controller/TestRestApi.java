package com.tg.spel.controller;

import com.tg.spel.params.RequestTest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangyujie
 */
@RestController
public class TestRestApi {
    @RequestMapping("/test")
    public String getApp(@ModelAttribute @Validated RequestTest test, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return "app";
    }
}

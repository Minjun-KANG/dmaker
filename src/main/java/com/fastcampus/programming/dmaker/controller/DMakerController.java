package com.fastcampus.programming.dmaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
//사용자 입력이 최초로 받아들여지는 Controller
public class DMakerController {

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
      log.info("GET /developers HTTP/1.1");

      return Arrays.asList("snow", "Elsa", "Olaf");
    }

}

package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
//사용자 입력이 최초로 받아들여지는 Controller
public class DMakerController {
    private final DMakerService dMakerService;

    //DmkaerController(Bean)  DmakerService(bean)   DeveloperRepository(Bean)
    //=================spring Application===================================
    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
      log.info("GET /developers HTTP/1.1");

      return Arrays.asList("snow", "Elsa", "Olaf");
    }

    @GetMapping("/create-developer")
    public List<String> createDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /create-developer HTTP/1.1");

        dMakerService.createDeveloper();

        return Collections.singletonList("Olaf");
    }

}

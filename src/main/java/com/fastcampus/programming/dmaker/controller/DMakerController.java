package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.dto.CreatedDeveloper;
import com.fastcampus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.programming.dmaker.dto.DeveloperDto;
import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<DeveloperDto> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllDevelopers();
    }

    @GetMapping("/developers/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreatedDeveloper.Response createDevelopers(
        @Valid @RequestBody CreatedDeveloper.Request request){
        //valid가 있어야 앞에 Nonnull 등 조건이 불만족하면 엑셉션을 띄운다.

        log.info("request : {}", request);

        dMakerService.createDeveloper(request);

        return dMakerService.createDeveloper(request);
    }

}

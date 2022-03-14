package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreatedDeveloper;
import com.fastcampus.programming.dmaker.dto.DeveloperDto;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//어플리케이션을 직접띄우는 것과 비슷하게, 통합테스트 함.
@SpringBootTest
class DMakerServiceTest2 {

    @Autowired//Dmaker Injection
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        dMakerService.createDeveloper(CreatedDeveloper.Request.builder()
                        .developerLevel(DeveloperLevel.SENIOR)
                        .developerSkillType(DeveloperSkillType.FRONT_END)
                        .experienceYears(12)
                        .memberId("memberId")
                        .name("name")
                        .age(32)
                        .build());
        List<DeveloperDto> allEmployedDevelopers = dMakerService.getAllEmployedDevelopers();

        System.out.println("===========================");
        System.out.println(allEmployedDevelopers);
        System.out.println("===========================");
    }
}
package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreatedDeveloper;
import com.fastcampus.programming.dmaker.entitiy.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Transactional
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(CreatedDeveloper.Request request) {
            //Business logic start
            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();

            developerRepository.save(developer);


    }

}
//2022-02-24
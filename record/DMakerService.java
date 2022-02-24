package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.entitiy.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    //자동으로 Injection 받아야되는 것을 private final 로.
    private final EntityManager em;

    // ACID
    // Atomic
    // Consistency
    // Isolation
    // Durability

    //비즈니스 로직이 앞뒤로 특정 처리가 필요함 -> AOP로 처리
    //아래코드는 AOP로 미처리한 코드임
    @Transactional
    public void createDeveloper() {
        EntityTransaction transaction = em.getTransaction();
        try {

            //Business logic start
            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();

            // A -> B 1만원 송금
            // A 계좌 1만원 줄임
            developerRepository.save(developer);
            // B 계좌 1만원 늘림
            developerRepository.delete(developer);
            developerRepository.save(developer);

            //Business logic end

            transaction.commit();
        } catch (Exception e) { //Rollback
            transaction.rollback();
            throw e;
        }
    }

}

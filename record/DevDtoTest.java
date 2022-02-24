package com.developers.dmkaer.dto;

import com.developers.dmaker.dto.DevDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DevDtoTest {
    @Test
    void test() {
        //Builder Annotation 사용한경우, 아래와 같이 attomic하게 인자를 전달할 수 있다.
        // 중간에 setAge등으로 값을 계속 건들다보면 코드가 지저분해지는 경우가 많다.
        // 따라서 final 키워드로 상수화 시킴과 동시에, 빌더를 사용하는 것이 좋다.
        final DevDto devDto = DevDto.builder()
                .name("snow2")
                .age(21)
                .startAt(LocalDateTime.now())
                .build();


//        DevDto devDto = new DevDto();
//
//        devDto.setName("snow");
//        devDto.setAge(21);
//        devDto.setStartAt(LocalDateTime.now());
        System.out.println(devDto.getName());

    }



}

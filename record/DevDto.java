package com.developers.dmaker.dto;


import lombok.*;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//ToString 어노의 경우, 객체 자체를 바로 출력하면, 래퍼런스의 값이 나오는데, tostring은 객체의 필드가 담고있는 내용까지 보여준다.
@NoArgsConstructor // 인자없는 생성자
@AllArgsConstructor // 전체 인자를 포함한
@RequiredArgsConstructor //필요한 것만

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode. 를 포함한 annotation
//하지만 양날에 검이다. ToString이 이에 해당한다. DTO에 개인정보를 담는 경우, 에러 메시지같은데 원치않는 개인정보가 출력될 가능성이 있다.
//롬복 버전에 따라 NoArgsConstructor등과 같이 사용하면 에러가 나는 경우가 있다.

@Builder // Builder pattern

@Slf4j // 간편한 로그를 출력가능

@UtilityClass // Bean에 등록하지 않고, 날짜변환이나 이런것들을 함. 편한거
public class DevDto {
    private String name;
    private Integer age;
    private LocalDateTime startAt;
}
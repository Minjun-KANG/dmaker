package com.fastcampus.programming.dmaker.dto;

import com.fastcampus.programming.dmaker.exception.DMakerErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//실무에서 아래와 같이 잘함.
//성공때 return 값따로, 실패에 Return 값 따로 구성한다고 함.
public class DmakerErrorResponse {
    private DMakerErrorCode errorCode;
    private String errorMessage;
}

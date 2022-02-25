package com.fastcampus.programming.dmaker.exception;

import lombok.Getter;

@Getter
public class DMakerException extends RuntimeException {
    //custom exception, 에러코드와 그에 상응하는 메시지
    private DMakerErrorCode dMakerErrorCode;
    private String detailMessage;

    public DMakerException(DMakerErrorCode errorCode){
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public DMakerException(DMakerErrorCode errorCode, String detailMessage){
        super(errorCode.getMessage());
        this.dMakerErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}

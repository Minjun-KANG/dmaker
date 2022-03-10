package com.fastcampus.programming.dmaker.exception;

import com.fastcampus.programming.dmaker.dto.DmakerErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.INTERNAL_SERVER_ERROR;
import static com.fastcampus.programming.dmaker.exception.DMakerErrorCode.INVALID_REQUEST;

@Slf4j
@RestControllerAdvice //각 컨트롤러에 조언을 해주는 그런 어드바이스이고, Bean으로 등록하기 위한 어노테이션
public class DMakerExceptionHandler {
    //linux에서 했던 것처럼 예외 에러처리를 하려고하지 않고 어노테이션 가능
    @ExceptionHandler(DMakerException.class) // 컨트롤러에서 발생하는 Dmaker exception은 여기서 처리를하고, 바로 response를 만들어줌
    public DmakerErrorResponse handleException(DMakerException e, HttpServletRequest request) {
        log.error("errorCode:{}, url: {}, message: {}",
                e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return DmakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }
    //요청이 잘못된 경우
    @ExceptionHandler(value = {
            //각 메소드에 다른 http 메소드를 통해 접근이 들어온다면 이로 처리함.
            HttpRequestMethodNotSupportedException.class,
            //우리가 자바빈 밸리데이션을 하기 때문에, NotNull, Min max등의 밸리데이션에서 문제가 발생하면 아래 엑셉션이 발생함.
            MethodArgumentNotValidException.class
    })
    public DmakerErrorResponse handleBadRequest(
            Exception e, HttpServletRequest request
    ) {
        log.error("url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return DmakerErrorResponse.builder()
                .errorCode(INVALID_REQUEST) //static화 한 것
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();
    }
    //진짜 모르는 에러일때, 그냥 엑셉션
    @ExceptionHandler(Exception.class)
    public DmakerErrorResponse handleException(
            Exception e, HttpServletRequest request
    ) {
        log.error("url: {}, message: {}",
                request.getRequestURI(), e.getMessage());

        return DmakerErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR) //진짜 모르는 에러이기 때문에 발견할 때마다 하나씩 DTO에 넣어주면 좋음.
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

}

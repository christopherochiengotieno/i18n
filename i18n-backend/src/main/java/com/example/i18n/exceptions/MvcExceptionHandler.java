package com.example.i18n.exceptions;

import com.example.i18n.config.LocaleConfig;
import com.example.i18n.model.dto.ErrorDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class MvcExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> exception(Exception e) {
        return ResponseEntity.badRequest().body(ErrorDetailsDto.builder().message(e.getMessage()).build());
    }
}

package com.example.i18n.controller;

import com.example.i18n.config.LocaleConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class SampleI18nController {

    private final MessageSource messageSource;
    @GetMapping
    public ResponseEntity<?> test(@RequestParam Boolean fail) {
        if (fail)
            throw new RuntimeException("error.failed");
        String response = messageSource.getMessage("test", null, LocaleConfig.GLOBAL_LOCALE);
        return ResponseEntity.ok().body(response);
    }
}

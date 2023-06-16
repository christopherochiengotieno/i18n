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
    @GetMapping
    public ResponseEntity<?> test(@RequestParam Boolean fail) {
        if (fail)
            throw new RuntimeException("Error occurred");
        return ResponseEntity.ok().body("Success Response");
    }
}

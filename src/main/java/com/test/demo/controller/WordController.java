package com.test.demo.controller;

import com.test.demo.domain.WordInfo;
import com.test.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/word")
    @ResponseStatus(HttpStatus.OK)
    public WordInfo getWordInfo(String word) {
        return wordService.getWordInfo("рука");
    }
}

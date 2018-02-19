package com.test.demo.controller;

import com.test.demo.domain.WordInfo;
import com.test.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WordInfo getWordInfo(@RequestParam("word") String word) throws IOException {
        return wordService.getWordInfo(word);
    }
}

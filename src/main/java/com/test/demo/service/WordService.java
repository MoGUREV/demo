package com.test.demo.service;

import com.test.demo.domain.WordInfo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface WordService {
    WordInfo getWordInfo(String word) throws IOException;
}

package com.test.demo.service.impl;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import com.test.demo.domain.WordInfo;
import com.test.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class WordServiceImpl implements WordService {
    private final String VOWELS = "аоуиеі";
    @Autowired
    private Translate translate;

    public WordInfo getWordInfo(String word) {
        WordInfo wordInfo = new WordInfo();
        wordInfo.setLength(word.length());
        wordInfo.setVowelCount(countOfVowel(word));
        wordInfo.setConsonantCount(countOfConsonant(word));
        Translation translation = translate.translate(word,
                Translate.TranslateOption.sourceLanguage("uk"),
                Translate.TranslateOption.targetLanguage("en"));
        wordInfo.setTranslation(translation.getTranslatedText());
        return wordInfo;
    }

    private int countOfVowel(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            String symbol = String.valueOf(word.charAt(i));
            if(VOWELS.contains(symbol)) {
                count++;
            }
        }
        return count;
    }

    private int countOfConsonant(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            String symbol = String.valueOf(word.charAt(i));
            if(!VOWELS.contains(symbol)) {
                count++;
            }
        }
        return count;
    }
}

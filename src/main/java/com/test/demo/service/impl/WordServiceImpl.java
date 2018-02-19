package com.test.demo.service.impl;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.test.demo.domain.WordInfo;
import com.test.demo.service.WordService;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    private final String VOWELS = "аоуиеі";
    private final Translate TRANSLATE = TranslateOptions.getDefaultInstance().getService();

    public WordInfo getWordInfo(String word) {
        WordInfo wordInfo = new WordInfo();
        wordInfo.setLength(word.length());
        wordInfo.setVowelCount(countOfVowel(word));
        wordInfo.setConsonantCount(countOfConsonant(word));
        Translation translation = TRANSLATE.translate(word,
                Translate.TranslateOption.sourceLanguage("ua"),
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

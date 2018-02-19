package com.test.demo.domain;

public class WordInfo {
    private int length;
    private int vowelCount;
    private int consonantCount;
    private String translation;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVowelCount() {
        return vowelCount;
    }

    public void setVowelCount(int vowelCount) {
        this.vowelCount = vowelCount;
    }

    public int getConsonantCount() {
        return consonantCount;
    }

    public void setConsonantCount(int consonantCount) {
        this.consonantCount = consonantCount;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}

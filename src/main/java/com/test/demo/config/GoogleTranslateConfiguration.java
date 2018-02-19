package com.test.demo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class GoogleTranslateConfiguration {

    @Bean
    public Translate translate() throws IOException {
        GoogleCredentials credentials;
        File file = new File(new ClassPathResource("credentials.json").getURI());
        try (FileInputStream inputStream = new FileInputStream(file)) {
            credentials = ServiceAccountCredentials.fromStream(inputStream);
        }
        return TranslateOptions.newBuilder().setCredentials(credentials).build().getService();
    }
}

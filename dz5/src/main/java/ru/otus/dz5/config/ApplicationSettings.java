package ru.otus.dz5.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ConfigurationProperties("application")
public class ApplicationSettings {

    private String[] csvFile;

    public void setCsvFile(String csvFile) {
        String[] strings = csvFile.split(",");
        this.csvFile = strings;
    }

    public String[] getCsvFile() {
        return csvFile;
    }

}

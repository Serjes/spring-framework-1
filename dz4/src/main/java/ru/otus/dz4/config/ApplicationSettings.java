package ru.otus.dz4.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ConfigurationProperties("application")
public class ApplicationSettings {

    private String[] csvFile;
    private String messageBundlePath;

    public void setCsvFile(String csvFile) {
        String[] strings = csvFile.split(",");
        this.csvFile = strings;
    }

    public String[] getCsvFile() {
        return csvFile;
    }

    public void setMessageBundlePath(String messageBundlePath) {
        this.messageBundlePath = messageBundlePath;
    }

    public String getMessageBundlePath() {
        return messageBundlePath;
    }

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
//        ms.setBasename("/i18n/bundle");
        ms.setBasename(getMessageBundlePath());
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}

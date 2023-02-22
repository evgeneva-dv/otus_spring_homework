package ru.otus.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class QuestionResourceLoader implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Value("${application.path}")
    private String resourcePath;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    public File getFile() {

        try {
            File file = resourceLoader.getResource(resourcePath).getFile();
            file.exists();
            return file;

        } catch (IOException e) {
            System.out.println("Fail 1");
            return null;
        }
    }
}

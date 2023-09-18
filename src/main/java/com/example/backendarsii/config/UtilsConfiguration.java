package com.example.backendarsii.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UtilsConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilsConfiguration.class);
    public static final String[] pdfExtensions = {"pdf"};
    public static final String[] pdfMimeTypes = {"application/pdf"};
    public static final String[] imageExtensions = {"png", "jpeg", "jpg", "bmp", "gif"};
    public static final String[] imageMimeTypes = {"image/jpeg", "image/bmp", "image/png", "image/gif"};

    public static boolean isPdf(String extension) {
        String lowercaseExtension = extension.toLowerCase();
        LOGGER.debug("************************** isPdf ? {" + lowercaseExtension + "}");
        return Arrays.asList(pdfMimeTypes).contains(lowercaseExtension);
    }

    public static boolean isImage(String extension) {
        String lowercaseExtension = extension.toLowerCase();

        return Arrays.asList(imageMimeTypes).contains(lowercaseExtension);
    }
}

package com.nwo.libmanager;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestResourceManager {

    private TestResourceManager() {
    }

    private static ResourceBundle rb = ResourceBundle.getBundle("test");
    private static String smallTestJsonPath;
    private static String bigTestJsonPath;
    private static String toStringOfConvertedSmallTest;
    private static String toStringOfConvertedBigTest;

    public static String getSmallTestJsonPath() {
        return rb.getString("smallTestJsonPath");
    }

    public static String getBigTestJsonPath() {
        return rb.getString("bigTestJsonPath");
    }

    public static String getToStringOfConvertedSmallTest() {
        return getToStringFormFile(getToStringOfConvertedSmallTestPath());
    }

    public static String getToStringOfConvertedBigTest() {
        return getToStringFormFile(getToStringOfConvertedBigTestPath());

    }

    private static String getToStringOfConvertedSmallTestPath() {
        return rb.getString("toStringOfConvertedSmallTest");
    }

    private static String getToStringOfConvertedBigTestPath() {
        return rb.getString("toStringOfConvertedBigTest");
    }

    private static String getToStringFormFile(String path) {
        try {
            return FileUtils.readFileToString(new File(path), UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
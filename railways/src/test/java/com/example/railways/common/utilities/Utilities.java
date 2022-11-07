package com.example.railways.common.utilities;

import net.bytebuddy.utility.RandomString;

public class Utilities {

    public static String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
}

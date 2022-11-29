package com.example.tadashboard.common.utilities;

import net.bytebuddy.utility.RandomString;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {

    public static String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public static String generateRandomStringWithSpecialChars(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(int length) {
        String domain = "@m.o";
        return generateRandomString(length - domain.length()) + domain;
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Date generateRandomDate(Date startDate, Date endDate) {
        long randomDay = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        return new Date(randomDay);
    }

    public static Date getDateAheadFromCurrentDate(int num) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, num);
        return c.getTime();
    }

    public static String formatDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}

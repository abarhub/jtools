package org.jtools.utils;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern PATTERN_NUMBER = Pattern.compile("\\d+");

    public static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        return PATTERN_NUMBER.matcher(strNum).matches();
    }

}

package com.github.isliqian.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:liqian
 * Date:2020/3/3
 * Desc:String常用工具
 */
public class StringTools {

    /**
     *  判断字符串是否为空 包括是否为null，是否为空字符串，过滤完空格后是否为空字符串
     */
    public static boolean isNullOrEmpty(final String str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  包括是否为null，是否为空字符串，过滤完空格后是否为空字符串
     */
    public static boolean isAbsEmpry(final String str) {
        if (str == null) {
            return true;
        } else {
            return str.trim().isEmpty();
        }
    }

    /**
     *  过滤特殊字符
     */
    public static boolean checkStr(final String str) {
        String regEx = "[`~!@#$%^&*<>]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  去除字符串中的所有空格
     */
    public static String removeBlank(String str) {
        String result = "";
        result = str.replace(" ", "");
        return result.trim();
    }




}

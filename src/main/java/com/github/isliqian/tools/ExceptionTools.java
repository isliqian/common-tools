package com.github.isliqian.tools;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Author:liqian
 * Date:2020/3/3
 * Desc: 异常信息堆栈工具
 */
public class ExceptionTools {

    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}

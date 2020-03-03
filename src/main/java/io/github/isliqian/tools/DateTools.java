package io.github.isliqian.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Author:liqian
 * Date:2020/3/3
 * Desc:常用时期转换工具
 */
public class DateTools {
    /** */
    public static final String YYYY = "yyyy";
    /** */
    public static final String YYYY_MM = "yyyy-MM";
    /** */
    public static final String YYYY_MM_DD_1 = "yyyy-MM-dd";
    /** */
    public static final String YYYY_MM_DD_2 = "yyyy年MM月dd日";
    /** */
    public static final String YYYY_MM_DD_3 = "yyyyMMdd";
    /** */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /** */
    public static final String YYYY_MM_DD_HH_MM_SS_1 = "yyyy-MM-dd HH:mm:ss";
    /** */
    public static final String YYYY_MM_DD_HH_MM_SS_2 = "yyyyMMddHHmmss";
    /** */
    public static final String HH_MM = "HH:mm";

    /**
     * 字符串转换成日期
     */
    public static Date str2Date(String str,String formate) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat(formate).parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转换为字符串
     */
    public static String date2Str(Date date,String formate) {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat(formate).format(date);
    }

    /**
     * 当前日期
     *
     * @return 系统当前时间
     */
    public static Date getDate() {
        return new Date();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<Date> findDate(int computeType, String dBegin, String dEnd) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(computeType == 3 ? YYYY : (computeType == 2 ? YYYY_MM : YYYY_MM_DD_1));
        List lDate = new ArrayList();
        Date startDate = sdf.parse(dBegin);
        Date endDate = sdf.parse(dEnd);
        while (startDate.before(endDate) || startDate.equals(endDate)) {
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(computeType == 3 ? Calendar.YEAR : (computeType == 2 ? Calendar.MONTH : Calendar.DAY_OF_MONTH), 1);
            Date end = c.getTime();

            lDate.add(startDate);

            startDate = end;
        }
        return lDate;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        //lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()) || dEnd.equals(calBegin.getTime())) {
            lDate.add(calBegin.getTime());
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
        }
        return lDate;
    }

    /**
     * @param t1
     * @param t2
     * @return
     */
    public static <T> List<T> compare(List<T> t1, List<T> t2) {
        List<T> list3 = new ArrayList<T>();
        for (T t : t2) {
            if (!t1.contains(t)) {
                list3.add(t);
            }
        }
        return list3;
    }

    /**
     */
    public static Date getCurrYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     */
    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 从0开始，比如说如果输入5的话，实际上显示的是4月份的最后一天
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }

    /**
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }
}

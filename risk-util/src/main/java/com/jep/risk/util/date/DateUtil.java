package com.jep.risk.util.date;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午10:03
 */


/* **********************
 *
 * SimpleDateFormat是线程不安全的
 *
 * JDK8 LocalDate / LocalDateTime 是线程安全的
 *
 * *********************/
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    //时间字符串的格式
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";


    /**
     * description: DateTimeFormatter设置时间格式
     *
     * @param :
     * @return java.time.format.DateTimeFormatter
     */
    private static DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern(PATTERN);
    }

    /* **********************
     *
     * LocalDateTime 和 String 的互相转换
     *
     * *********************/

    /**
     * description: LocalDateTime转换为字符串
     *
     * @param dateTime:
     * @return java.lang.String
     */
    public static String convertLocalDateTime2Str(LocalDateTime dateTime) {
        DateTimeFormatter dtf = getFormatter();
        return dtf.format(dateTime);
    }


    /**
     * description: 字符串转换为LocalDateTime
     *
     * @param str:
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime convertStr2LocalDateTime(String str) {
        DateTimeFormatter dtf = getFormatter();
        return LocalDateTime.parse(str, dtf);
    }


    /* **********************
     *
     *
     * 时间戳 和 LocalDateTime 的互相转换
     *
     * *********************/

    /**
     * description: 时间戳转换为LocalDateTime
     *
     * @param timestamp:
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime convertTimestamp2LocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * description: LocalDateTime转换为时间戳
     *
     * @param dateTime:
     * @return long
     */
    public static long convertLocalDateTime2Timestamp(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
}

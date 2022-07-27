package com.kata.sg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static Date getDateWithTimeUsingFormat() {
        DateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);
        return strToDate(getCurrentDate(), YMDHMS_FORMAT);

    }

    public static String getCurrentDate() {
        return getFormatDate("yyyy-MM-dd HH:mm:ss");
    }

    protected static String getFormatDate(String formatString) {
        String currentDate = "";
        SimpleDateFormat format1 = new SimpleDateFormat(formatString);
        currentDate = format1.format(new Date());
        return currentDate;
    }

    public static Date strToDate(String str, DateFormat DateFormat) {

        Date date = null;
        try {
            date = DateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }






}
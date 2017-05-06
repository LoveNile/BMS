package com.bms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getNowDate() {
        return new Date();
    }

    public static Date getSimpleDate(String dateString) {
        Date date = null;
        if (!dateString.equals("")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = simpleDateFormat.parse(dateString);
            } catch (ParseException e) {
                date = getNowDate();
            }
        }
        return date;
    }
}

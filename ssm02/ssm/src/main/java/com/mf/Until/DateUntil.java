package com.mf.Until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntil {
    private  static SimpleDateFormat simpleDateFormat;

    static {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static Date StrToDate(String str){
        Date date = null;
        try {
            date =  simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DateToStr(Date date){
        return simpleDateFormat.format(date);
    }
}

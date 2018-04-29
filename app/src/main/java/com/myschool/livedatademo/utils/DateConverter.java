package com.myschool.livedatademo.utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by dilip on 20/2/18.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    public static Long toTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }
}

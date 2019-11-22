package com.geektech.quizapp_4_1.data.db.converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class TimestampConverter {

    @TypeConverter
    public static Date fromTimestamp(Long time) {
        if (time == null) {
            return null;
        } else {
            return new Date(time);
        }
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? 0L : date.getTime();
    }

}

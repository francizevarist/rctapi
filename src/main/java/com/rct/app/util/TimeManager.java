package com.rct.app.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManager {

    private String date;
    public TimeManager() {}

    /**
     *******************************************************************************************************************
     * Time Stamp To Date & Time Convension
     *******************************************************************************************************************
     */

    //Time stamp to date format
    public static String timeStampToDate(long timestamp){
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        String dateTime = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return dateTime;
    };

    //Time stamp to time format
    public static String timeStampToTime(long timestamp){
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        String dateTime = new SimpleDateFormat("hh:mm:ss").format(date);
        return dateTime;
    };

    //Time stamp to time format  ( Am & Pm)
    public static String timeStampToTimeExtended(long timestamp){
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        String dateTime = new SimpleDateFormat("hh:mm:ss aa").format(date);
        return dateTime;
    };

    //time stamp to date and time
    public static String timeStampToDateAndTime(long timestamp){
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        String dateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(date);
        return dateTime;
    };

    //time stamp to date and time (Am & Pm)
    public static String timeStampToDateAndTimeExtended(long timestamp){
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        String dateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa").format(date);
        return dateTime;
    };


    /**
     *******************************************************************************************************************
     *Date & Time To TimeStamp Convension
     *******************************************************************************************************************
     */
    public static long currentTimeStamp(){
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    //date to timestamp
    public static String dateToTimeStamp(String inputDateTimeInString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(inputDateTimeInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return Long.toString(timestamp.getTime());
    }

    //time to timestamp
    public static String timeToStamp(String inputtDateinString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(inputtDateinString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return Long.toString(timestamp.getTime());
    }

    //time (Am & Pm) to timetamp
    public static String timeExtendedToTimeStamp(String inputTimeInString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(inputTimeInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return  Long.toString(timestamp.getTime());
    }

    //date & time to timestamp
    public static String dateAndTimeToTimeStamp(String inputTimeAndTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(inputTimeAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return  String.valueOf(timestamp.getTime());
    }

    //date & time (Am & Pm) to timestamp
    public static String dateAndTimeExtendedToTimeStamp(String inputTimeAndTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(inputTimeAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return  String.valueOf(timestamp.getTime());
    }

}

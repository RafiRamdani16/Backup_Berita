package com.example.mynews;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FormatTime {

    public static String convertTime(String time){

        String[] date = time.replace("T", "-")
                .replace("Z", "-")
                .replace(":", "-")
                .split("-");

        int year_a = Integer.parseInt(date[0]);
        int month_a = Integer.parseInt(date[1]);
        int day_a = Integer.parseInt(date[2]);

        Calendar cal_a = Calendar.getInstance();
        cal_a.set(year_a,month_a,day_a);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(cal_a.getTime());

        String cTime = formattedDate + "";
        return cTime;
    }

    public static String convertDetailTime(String time){
        String[] date = time.replace("T", "-")
                .replace("Z", "-")
                .replace(":", "-")
                .split("-");

        int year_a = Integer.parseInt(date[0]);
        int month_a = Integer.parseInt(date[1]);
        int day_a = Integer.parseInt(date[2]);
        int hour_a = Integer.parseInt(date[3]);
        int minute_a = Integer.parseInt(date[4]);

        Calendar cal_a = Calendar.getInstance();
        Calendar cal_b = Calendar.getInstance();


        cal_a.set(year_a,month_a,day_a);
        cal_b.set(hour_a,minute_a);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(cal_a.getTime());

        SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
        String formattedTime = tf.format(cal_b.getTime());

        String ctime = formattedDate + " | " + formattedTime;

        return ctime;
    }

    public static String getHour(String hour) {
        String result = "";
        if (hour.equals("00")) {
            result = "07";
        } else if (hour.equals("01")) {
            result = "08";
        } else if (hour.equals("02")) {
            result = "09";
        } else if (hour.equals("03")) {
            result = "10";
        } else if (hour.equals("04")) {
            result = "11";
        } else if (hour.equals("05")) {
            result = "12";
        } else if (hour.equals("06")) {
            result = "13";
        } else if (hour.equals("07")) {
            result = "14";
        } else if (hour.equals("08")) {
            result = "15";
        } else if (hour.equals("09")) {
            result = "16";
        } else if (hour.equals("10")) {
            result = "17";
        } else if (hour.equals("11")) {
            result = "18";
        } else if (hour.equals("12")) {
            result = "19";
        } else if (hour.equals("13")) {
            result = "20";
        } else if (hour.equals("14")) {
            result = "21";
        } else if (hour.equals("15")) {
            result = "22";
        } else if (hour.equals("16")) {
            result = "23";
        } else if (hour.equals("17")) {
            result = "00";
        } else if (hour.equals("18")) {
            result = "01";
        } else if (hour.equals("19")) {
            result = "02";
        } else if (hour.equals("20")) {
            result = "03";
        } else if (hour.equals("21")) {
            result = "04";
        } else if (hour.equals("22")) {
            result = "05";
        } else if (hour.equals("23")) {
            result = "06";
        }
        return result;
    }

}

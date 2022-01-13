package co.com.practice.utils;

import static java.time.LocalDateTime.now;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZone {

    public static String validation(String timeZone){

        LocalDateTime localDateTime = LocalDateTime.of(
                now().getYear(),
                now().getMonth(),
                now().getDayOfMonth(),
                now().getHour(),
                now().getMinute());
        ZoneId zoneBogota = ZoneId.of("America/Bogota");
        ZonedDateTime bogotaZonedDateTime = localDateTime.atZone(zoneBogota);
        ZoneId timeZoneValidate = ZoneId.of(timeZone);
        ZonedDateTime myDateTime = bogotaZonedDateTime.withZoneSameInstant(timeZoneValidate);

        String month = myDateTime.getMonthValue() < 10 ? "0"+myDateTime.getMonthValue() :
                String.valueOf(myDateTime.getMonthValue());
        String day = myDateTime.getDayOfMonth() < 10 ? "0"+myDateTime.getDayOfMonth() :
                String.valueOf(myDateTime.getDayOfMonth());
        String hour = myDateTime.getHour() < 10 ? "0"+myDateTime.getHour() :
                String.valueOf(myDateTime.getHour());
        String minute = myDateTime.getMinute() < 10 ? "0"+myDateTime.getMinute() :
                String.valueOf(myDateTime.getMinute());

        return myDateTime.getYear()+"-"+month+"-"+day+"T"+hour+":"+minute;
    }

    private TimeZone(){

    }
}
package zhi.jery.date;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static void main(String[] args) {
        System.out.println("Locale.getDefault() = " + Locale.getDefault());
        System.out.println("ZoneId.systemDefault() = " + ZoneId.systemDefault());

//        ZoneId zone = ZoneId.of("EST", ZoneId.SHORT_IDS);
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2019-05-05T12:56:01.000Z",
//                DateTimeFormatter.ISO_INSTANT.withZone(zone));
//        System.out.println("zonedDateTime = " + zonedDateTime);
//
//        String localDateTimeText = zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//        System.out.println("localDateTimeText = " + localDateTimeText);
//
//        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeText);
//        System.out.println("Date.from(localDateTime.toInstant(ZoneOffset.UTC)) = "
//                + Date.from(localDateTime.toInstant(ZoneOffset.UTC)));

        parse("2019-05-05","13:26:00","EST");
    }

    public static void parse(String dateText, String timeText, String zoneText) {
        String dateTimeText = new StringBuffer().append(dateText).append("T").append(timeText).append(".000Z").toString();
        ZoneId zoneId = ZoneId.of(zoneText, ZoneId.SHORT_IDS);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeText, DateTimeFormatter.ISO_INSTANT.withZone(zoneId));
        System.out.println("dateTimeText = " + dateTimeText);
        System.out.println("zoneId = " + zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);

        String localDateTimeText = zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTimeText = " + localDateTimeText);
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeText);
        System.out.println("Date.from(localDateTime.toInstant(ZoneOffset.UTC)) = " + Date.from(localDateTime.toInstant(ZoneOffset.UTC)));

    }

}

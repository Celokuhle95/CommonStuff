package com.celo.learn.springboot_revisit;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateConvertor {

    public static void main(String... args) {
        Date date = new Date();
        System.out.println(String.format("util date1: %s", date));

        DateConvertor dateConvertor = new DateConvertor();
        LocalDate localDate = dateConvertor.getLocalDateFormUtilDate(date);
        System.out.println(String.format("local date: %s", localDate));

        Date utilDate2 = dateConvertor.getUtilDateFromFormUtilDate(localDate);
        System.out.println(String.format("util date 2: %s", utilDate2));
    }

    public LocalDate getLocalDateFormUtilDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return  zdt.toLocalDate();
    }

    public Date getUtilDateFromFormUtilDate(LocalDate localDate) {
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return  date;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

/**
 *
 * @author vince-kong
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class PickerUtilities {

    public static DateTimeFormatter createFormatterFromPatternString(
        String formatPattern, Locale locale) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseLenient()
                .parseCaseInsensitive().appendPattern(formatPattern)
                .toFormatter(locale);
        return formatter;
    }

  
    public static boolean isLocalTimeInRange(LocalTime value,
            LocalTime optionalMinimum, LocalTime optionalMaximum, boolean inclusiveOfEndpoints) {
        // If either bounding time does does not already exist, then set it to the maximum range.
        LocalTime minimum = (optionalMinimum == null) ? LocalTime.MIN : optionalMinimum;
        LocalTime maximum = (optionalMaximum == null) ? LocalTime.MAX : optionalMaximum;
        // Null is never considered to be inside of a range.
        if (value == null) {
            return false;
        }
        // Return false if the range does not contain any times.
        if (maximum.isBefore(minimum) || maximum.equals(minimum)) {
            return false;
        }
        if (inclusiveOfEndpoints) {
            return ((value.isAfter(minimum) || value.equals(minimum))
                    && (value.isBefore(maximum) || value.equals(maximum)));
        } else {
            return (value.isAfter(minimum) && value.isBefore(maximum));
        }
    }

    
    static public boolean isSameLocalDate(LocalDate first, LocalDate second) {
        // If both values are null, return true.
        if (first == null && second == null) {
            return true;
        }
        // At least one value contains a date. If the other value is null, then return false.
        if (first == null || second == null) {
            return false;
        }
        // Both values contain dates. Return true if the dates are equal, otherwise return false.
        return first.isEqual(second);
    }

    public static boolean isSameYearMonth(YearMonth first, YearMonth second) {
        // If both values are null, return true.
        if (first == null && second == null) {
            return true;
        }
        // At least one value contains a YearMonth. If the other value is null, then return false.
        if (first == null || second == null) {
            return false;
        }
        // Both values contain a YearMonth. 
        // Return true if the YearMonth are equal, otherwise return false.
        return first.equals(second);
    }

    public static boolean isSameLocalTime(LocalTime first, LocalTime second) {
        // If both values are null, return true.
        if (first == null && second == null) {
            return true;
        }
        // At least one value contains a time. If the other value is null, then return false.
        if (first == null || second == null) {
            return false;
        }
        // Both values contain times. Return true if the times are equal, otherwise return false.
        return first.equals(second);
    }


    public static String localDateTimeToString(LocalDateTime value, String emptyTimeString) {
        return (value == null) ? emptyTimeString : value.toString();
    }


    public static String localDateTimeToString(LocalDateTime value) {
        return (value == null) ? "" : value.toString();
    }

  
    static public String localDateToString(LocalDate date) {
        return localDateToString(date, "");
    }

   
    static public String localDateToString(LocalDate date, String emptyDateString) {
        return (date == null) ? emptyDateString : date.toString();
    }

   
    public static String localTimeToString(LocalTime time) {
        return (time == null) ? "" : time.toString();
    }

 
    public static String localTimeToString(LocalTime time, String emptyTimeString) {
        return (time == null) ? emptyTimeString : time.toString();
    }

}


package com.example.searchautocomplete.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
@Component
public class StringToDateConverter {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Date convertStringToDate(String value) {
        if(isValid(value)) {
            LocalDate localDate = LocalDate.parse(value);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        }
        return null;
    }

    private boolean isValid(String value) {
        try {
            LocalDate.parse(value, formatter);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }
}

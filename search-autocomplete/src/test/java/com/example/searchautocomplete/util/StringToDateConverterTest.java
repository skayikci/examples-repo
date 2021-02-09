package com.example.searchautocomplete.util;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringToDateConverterTest {

    @Autowired
    StringToDateConverter stringToDateConverter;

    @Test
    void shouldConvertCorrectFormatToDate() {
        // given
        var value = "2020-10-20";

        // when
        Date date = StringToDateConverter.convertStringToDate(value);

        // then
        assertEquals(date.getTime(), 1603144800000L);
    }

    @Test
    void shouldNotConvertWrongFormat() {
        // given
        var value = "20201020";

        // when
        Date date = StringToDateConverter.convertStringToDate(value);

        // then
        assertNull(date);
    }
}

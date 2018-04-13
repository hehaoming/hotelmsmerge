package com.hotelms.utils;

import org.springframework.core.convert.converter.Converter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MyDateConverter implements Converter<String,LocalDateTime>{
    @Override
    public LocalDateTime convert(String s) {
        /*2018-04-03 23:45:49*/
        return LocalDateTime.parse(s,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

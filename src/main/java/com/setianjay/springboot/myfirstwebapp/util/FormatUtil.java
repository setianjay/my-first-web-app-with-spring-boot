package com.setianjay.springboot.myfirstwebapp.util;

import java.time.LocalDate;

public class FormatUtil {

    public static LocalDate generalDateFormat(String date){
        return LocalDate.parse(date);
    }
}

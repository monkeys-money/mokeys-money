package br.com.fiap.fintech.monkeys_money.cross.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConverterHelper {

    public static Date convertToDateUtil(final LocalDateTime date){
        return Date.from(date.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
    }

    public static LocalDateTime convertToLocalDateTime(final Long time){
        Date date = new Date(time);

        return date.toInstant()
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toLocalDateTime();
    }
}

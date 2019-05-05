package com.example.seedstarter.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class DateFormatter implements Formatter<LocalDate> {

    @Autowired
    private MessageSource messageSource;

    public DateFormatter() {

    }

    @Override
    public LocalDate parse(String text, Locale locale) {
        DateTimeFormatter dateFormat = createDateFormat(locale);
        return LocalDate.parse(text, dateFormat);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        DateTimeFormatter dateFormat = createDateFormat(locale);
        return dateFormat.format(object);
    }

    private DateTimeFormatter createDateFormat(Locale locale) {
        String format = this.messageSource.getMessage("date.format", null, locale);
        return DateTimeFormatter.ofPattern(format);
    }
}

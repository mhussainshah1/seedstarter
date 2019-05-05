package com.example.seedstarter.conversion;

import com.example.seedstarter.entities.Variety;
import com.example.seedstarter.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.util.Locale;

@Configuration
public class VarietyFormatter implements Formatter<Variety> {

    @Autowired
    private VarietyService varietyService;

    public VarietyFormatter() {
    }

    @Override
    public Variety parse(String text, Locale locale) {
        int varietyId = Integer.valueOf(text);
        return this.varietyService.findById(varietyId);
    }

    @Override
    public String print(Variety variety, Locale locale) {
        return (variety != null ? Long.toString(variety.getId()) : "");
    }
}

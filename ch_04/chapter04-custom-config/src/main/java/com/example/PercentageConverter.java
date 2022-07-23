package com.example;

import org.eclipse.microprofile.config.spi.Converter;

import javax.annotation.Priority;

@Priority(300) // <1>
public class PercentageConverter implements Converter<Percentage> { // <2>

    @Override
    public Percentage convert(String value) {
        String numeric = value.substring(0, value.length() - 1);
        return new Percentage(Double.parseDouble(numeric) / 100);
    }

}

package com.mohan.nexttrip.rest.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StopDTO
{

    String text;

    String value;

    public String getText() {
        return text;
    }

    @JsonSetter("Text")
    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    @JsonSetter("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "StopDTO{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

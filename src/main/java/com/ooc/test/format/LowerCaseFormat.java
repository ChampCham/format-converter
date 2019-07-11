package com.ooc.test.format;

public class LowerCaseFormat implements Format {

    @Override
    public String convert(String name, String type) {
        return name.toLowerCase();
    }
}

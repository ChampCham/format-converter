package com.ooc.test.format;

public class UpperCaseFormat  implements Format{
    @Override
    public String convert(String name, String type) {
        return name.toUpperCase();
    }
}

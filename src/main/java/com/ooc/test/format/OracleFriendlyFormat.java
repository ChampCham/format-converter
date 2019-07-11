package com.ooc.test.format;

public class OracleFriendlyFormat implements Format{
    @Override
    public String convert(String name, String type) {
        String snakeText = new SnakeCaseFormat().convert(name,type);
        return new UpperCaseFormat().convert(snakeText,type);
    }
}

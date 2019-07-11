package com.ooc.test.format;

public class MySQLFriendlyFormat implements  Format {
    @Override
    public String convert(String name, String type) {
        return new SnakeCaseFormat().convert(name,type);
    }
}

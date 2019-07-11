package com.ooc.test.format;

public class MySQLFriendlyWithPrefixFormat implements Format {
    private final String prefix = "tbl_";
    @Override
    public String convert(String name, String type) {
        String mySQLText = new MySQLFriendlyFormat().convert(name,type);
        if (type.equals("class")){
            mySQLText = prefix+mySQLText;
        }
        return mySQLText;
    }
}

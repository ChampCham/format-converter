package com.ooc.test.format;

public class OracleFriendlyWithPrefixFormat implements Format{
    private final String prefix = "TBL_";
    @Override
    public String convert(String name, String type) {
        String oracleText = new OracleFriendlyFormat().convert(name,type);
        if (type.equals("class")){
            oracleText = prefix+oracleText;
        }
        return oracleText;
    }
}

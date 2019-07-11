package com.ooc.test.format;

import com.google.common.base.CaseFormat;

public class CamelCaseFormat implements Format{
    @Override
    public String convert(String text, String type) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,text);
    }
}

package com.ooc.test.format;

import com.google.common.base.CaseFormat;

public class PascalCaseFormat implements Format {
    @Override
    public String convert(String name, String type) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, name);
    }
}

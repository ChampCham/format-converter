package com.ooc.test.format;

import com.google.common.base.CaseFormat;

public class KebabCaseFormat implements Format {
    @Override
    public String convert(String name, String type) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN,name);
    }
}

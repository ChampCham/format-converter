package com.ooc.test.factory;

import com.ooc.test.format.*;

import java.util.LinkedHashMap;
import java.util.Map;

public interface FormatFactory {

    Map<String, Class<? extends Format>> registeredFormatClassesByName
            = new LinkedHashMap<String, Class<? extends Format>>()
    {
        {   put("camelCase", CamelCaseFormat.class);
            put("snake_case", SnakeCaseFormat.class);
            put("lowercase", LowerCaseFormat.class);
            put("UPPERCASE", UpperCaseFormat.class);
            put("kebab-case", KebabCaseFormat.class);
            put("PascalCase", PascalCaseFormat.class);
            put("MySQLFriendly", MySQLFriendlyFormat.class);
            put("OracleFriendly", OracleFriendlyFormat.class);
            put("MySQLFriendlyWithPrefix", MySQLFriendlyWithPrefixFormat.class);
            put("OracleFriendlyWithPrefix", OracleFriendlyWithPrefixFormat.class);
        }
    };

    Format create(String formatType);

}

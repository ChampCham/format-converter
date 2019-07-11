package com.ooc.test;

import com.ooc.test.exception.NotFoundException;
import com.ooc.test.format.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class FormatFactory {

    private static Map<String, Class<? extends Format>> registeredFormatClassesByName
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

    public static Format create(String formatType){

        Class<? extends Format> formatClass = registeredFormatClassesByName.get(formatType);
        Format format = null;
        try {
            format = formatClass.newInstance();
        }catch (InstantiationException | IllegalAccessException ex){
        }catch (NullPointerException npe){
            throw  new NotFoundException("Not found formatType: " + formatType);
        }
        return format;
    }

}

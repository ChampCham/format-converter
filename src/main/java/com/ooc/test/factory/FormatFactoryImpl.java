package com.ooc.test.factory;

import com.ooc.test.exception.NotFoundException;
import com.ooc.test.format.*;

public class FormatFactoryImpl implements FormatFactory {

    public Format create(String formatType){

        Class<? extends Format> formatClass = registeredFormatClassesByName.get(formatType);

        Format format = null;
        try {
            format = formatClass.newInstance();
        }catch (InstantiationException | IllegalAccessException ignored){
        }catch (NullPointerException npe){
            throw  new NotFoundException("Not found formatType: " + formatType);
        }
        return format;
    }
}

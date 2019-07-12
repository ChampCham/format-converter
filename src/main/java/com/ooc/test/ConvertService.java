package com.ooc.test;

import com.ooc.test.dto.RequestBodyDTO;
import com.ooc.test.factory.FormatFactory;
import com.ooc.test.factory.FormatFactoryImpl;
import com.ooc.test.format.Format;
import org.springframework.stereotype.Service;


@Service
public class ConvertService {

    public String convertToString(RequestBodyDTO dto) {
        return convertToString(dto.getFormat(),dto.getName(),dto.getType());
    }

    public String convertToString(String formatType,String name, String type) {
        FormatFactory formatFactory = new FormatFactoryImpl();
        Format format = formatFactory.create(formatType);
        return  format.convert(name,type);
    }
}

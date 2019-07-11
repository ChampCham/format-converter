package com.ooc.test;

import com.ooc.test.dto.RequestBodyDTO;
import com.ooc.test.dto.ResponseDTO;
import com.ooc.test.format.Format;
import org.springframework.stereotype.Service;


@Service
public class ConvertService {


    public ResponseDTO convertToResponseDTO(RequestBodyDTO dto) {
        String convertedName = convertToString(dto.getFormat(),dto.getName(),dto.getType());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponseName(convertedName);
        return responseDTO;
    }

    public String convertToString(String formatType,String name, String type) {
        Format format = FormatFactory.create(formatType);
        return  format.convert(name,type);
    }
}

package com.ooc.test;

import com.ooc.test.dto.RequestBodyDTO;
import com.ooc.test.dto.ResponseDTO;
import com.ooc.test.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private ConvertService convertService;

    private Set<String> validType = new HashSet<>(Arrays.asList("class","property"));

    @PostMapping("convert")
    public ResponseEntity<ResponseDTO> convert(@Valid @RequestBody RequestBodyDTO dto){
        ResponseDTO responseDTO = convertService.convertToResponseDTO(dto);
        if (!validType.contains(dto.getType())) throw new NotFoundException("type: "+dto.getType()+" not found");
        return ResponseEntity
                .ok()
                .body(responseDTO);
    }
}

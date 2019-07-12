package com.ooc.test;

import com.ooc.test.dto.RequestBodyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@Valid @RequestBody RequestBodyDTO dto){
        String convertedName = convertService.convertToString(dto);
        return ResponseEntity
                .ok()
                .body(convertedName);
    }
}

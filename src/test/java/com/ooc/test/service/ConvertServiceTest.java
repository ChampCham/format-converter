package com.ooc.test.service;

import com.ooc.test.ConvertService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.Assert.*;

@SpringBootTest
public class ConvertServiceTest {

    @Autowired
    private ConvertService convertService;

    @ParameterizedTest
    @CsvFileSource(resources = "/static/test-cases.csv", numLinesToSkip = 1)
    public void  testConvertToString(String name, String type, String format, String output){
        assertEquals(output,convertService.convertToString(format,name,type));
    }
}
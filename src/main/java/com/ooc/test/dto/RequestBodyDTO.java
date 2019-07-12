package com.ooc.test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RequestBodyDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;


    @NotBlank(message = "Type is mandatory")
    @Pattern(regexp = "(class|property)", message = "Type require only class or property")
    private String type;


    @NotBlank(message = "Format is mandatory")
    private String format;

}

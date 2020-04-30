package com.dev.serviceconfigproperties.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    @Value("${config.simpleProperty}")
    private String simpleProperty;

    @Value("${config.defaultValue: default value}")
    private String defaultValue;

    @Value("${config.listOfValues}")
    private List<Integer> listOfValues;

    @Value("#{${config.mapOfValues}}")
    private Map<String,String> mapOfValues;

    @GetMapping()
    public String getConfigValues(){
        return  " [ simpleProperty = " + simpleProperty + "]" +
                "\n [ defaultValue = " + defaultValue + "]" +
                "\n [ listOfValues = " + listOfValues + "]" +
                "\n [ mapOfValues = " + mapOfValues + "]";
    }
}

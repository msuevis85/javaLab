package com.centennial.laboratory.commands.enums;

/**
 * Enum to declare the type of conversion
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public enum ConversionType {
    CELSIUS_TO_FAHRENHEIT("Celsius to Fahrenheit"),
    FAHRENHEIT_TO_CELSIUS("Fahrenheit to Celsius");

    private String message;

    ConversionType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

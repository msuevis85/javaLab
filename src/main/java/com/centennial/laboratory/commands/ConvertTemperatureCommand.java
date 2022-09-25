package com.centennial.laboratory.commands;

import com.centennial.laboratory.commands.enums.ConversionType;

/**
 * Class that convert temperature for
 * example Centigrade to Fahrenheit.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class ConvertTemperatureCommand implements ICommand{

    private ConversionType type;
    private double temperature;

    public ConvertTemperatureCommand(ConversionType type, double temperature) {
        this.type = type;
        this.temperature = temperature;
    }


    public void printConversion( ){
        convert(this.type,this.temperature);
    }

    private void convert(ConversionType type, double temperature){
      double result = ConversionType.CELSIUS_TO_FAHRENHEIT.equals(type) ?
              convertCelsiusToFahrenheit(temperature) :
              convertFahrenheitToCelsius(temperature);

      printResult(type, temperature, result);
    }

    private void printResult(ConversionType type, double temperature, double result){
        System.out.println(String.format("The result after convert %s %s is %s",temperature,type.getMessage(),result));
    }

    private double convertCelsiusToFahrenheit(double celsius){
        return (celsius * 1.8 ) + 32;
    }

    private double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32 ) * 5/9;
    }

    @Override
    public void execute() {
        printConversion();
    }

}

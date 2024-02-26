/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.model;

/**
 *
 * @author Pawel Golabek
 */
/**
 *  Default model used to keep track of converters and manage actions connected 
 * to them
 */
public class DefaultModel {

    
/**
 *  Default constructor, just in case I ever needed it
 */
    public DefaultModel(){
        
    }
    /**
     * Calculates default farenheit to celcius conversion
     * @param x x in Ax+B conversion
     * @return  result in celcius
     */
    static public float calcutateFarenheitCelcius(float x){
        return (32.0f + 9.0f/5.0f * x);
    }

    /**
     * Calculates default celcius to farenheit conversion
     * @param x x in Ax+B conversion
     * @return result in farenheit
     */
    static public float calculateCelciusFarenheit(float x){
        return (32.0f - 5.0f/9.0f * x);
    }

    /**
     * Calculates from custom converter
     * @param x x in Ax+B conversion
     * @param converter converter of a choice providing a way to calculate
     * @return  result of the equasion made on the custom converter
     */
    static public float calculateCustom(float x, Converter converter){
        return ( converter.getA() * x + converter.getB() );
    }
}
    
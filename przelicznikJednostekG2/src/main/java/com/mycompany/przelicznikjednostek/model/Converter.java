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
*   Class to hold a single custom made converter
*/
public class Converter {
/**
*  
*/
    private String name;
    private float A;                // Ax + B
    private float B;
    
    /**
     * default converter constructor
     */
    public Converter(){
        this.name = "Undefined Controller";
        this.A = 1;
        this.B = 1;
    }
    
    /**
     * A and B are for the Ax+B formula.
     * @param name  name of the converter
     * @param A A value of the converter
     * @param B B value of the converter
     */
    public Converter(String name, float A, float B){
        this.name = name;
        this.A = A;
        this.B = B;
    }
    
    /**
     *  standard getter for name attribute
     * @return  name of the converter
     */
    public String getName(){
        return name;
    }

    /**
     *  standard getter for A attribute
     * @return  A parameter of the converter
     */
    public float getA(){
        return A;
    }

    /**
     * standard getter for B attribute
     * @return B parameter of the converter
     */
    public float getB(){
        return B;
    }

    /**
     *  standard setter for name attribute
     * @param name  name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  standard setter for A attribute
     * @param A A value to set
     */
    public void setA(float A) {
        this.A = A;
    }

    /**
     *  standard setter for B attribute
     * @param B  B value to set
     */
    public void setB(float B) {
        this.B = B;
    }

    /**
     * Returns a converted unit using Ax+B formula.
     * @param input x in Ax+B formula
     * @return  result of calculation in float format
     */
    public float calculate(float input){
        return this.A * input + this.B;
    }

}

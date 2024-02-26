/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.model;

/**
 *
 * @author Paweł Golabek
 */

/**
 *  Class to hold my basic exceptions
 */

public class MyException extends Exception {
    
    /**
     *  My custom exception
     */
    public MyException() {
        super("Cos nie tak z plikiem .ini");
    }

    /**
     * My custom exception with custom message
     * @param message   message to be sent in an exception
     */
    public MyException(String message) {
        super(message);
    }
    
    /**
     *  Standard generation something wrong with .ini exception
     * @throws MyException my exception for problems with .ini file
     */
    public static void generateException() throws MyException {
        throw new MyException("Cos nie tak z plikiem .ini");
    }

    /**
     *  custom exception thrower throwing a string
     * @param message message to send in an exception
     * @throws MyException my exception for problems with .ini file
     */
    public static void generateException(String message) throws MyException {
        throw new MyException("Cos nie tak z plikiem .ini");
    }

}

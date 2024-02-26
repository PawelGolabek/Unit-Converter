/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.controller;

/**
 *
 * @author Pawel Golabek
 */
/**
 * Responsible for handling an enumeration
 *
 */
public class ConsoleInputEnumHandler {

    /**
     *  enum for YES and NO values
     */
    public enum IsConsoleInputOk {
    /**
     * Indicates that console input is considered valid.
     */
    YES,

    /**
     * Indicates that console input is not considered valid.
     */
    NO
    }

    private IsConsoleInputOk isConsoleInputOk;

    /**
     * Constructs a new {@code ConsoleInputEnumHandler} with the initial state set to {@code NO}.
     */
    public ConsoleInputEnumHandler() {
        isConsoleInputOk = IsConsoleInputOk.NO;
    }

    /**
     * Gets the current state of the console input validation.
     *
     * @return The current state of the console input validation.
     */
    public IsConsoleInputOk getMyEnum() {
        return isConsoleInputOk;
    }

    /**
     * Sets the state of the console input validation.
     *
     * @param myEnum The new state of the console input validation.
     */
    public void setMyEnum(IsConsoleInputOk myEnum) {
        this.isConsoleInputOk = myEnum;
    }
}

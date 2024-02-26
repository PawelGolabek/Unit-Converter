/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.view;

import com.mycompany.przelicznikjednostek.model.ConverterList;
import java.util.Scanner;

/**
 *
 * @author Pawel Golabek
 */

/**
 *  View object to print things out in console
 */
public class DefaultView {
    
    
    /**
     * Default constructor
     */
    DefaultView(){
    }
    
//    public void printResult(String i){
//         System.out.println(i);
//}

    /**
     *  Prints out single line in console. Mostly used for results of equastions
     * @param i Float to print
     */
    public static void printResult(float i){
         System.out.println(i);
}

    /**
     *  Prints out basic menu in console
     * @return choice in menu
     */
    public static String menu()
    {
        System.out.println("Wprowadz:");
        System.out.println("1 dla Celcius->Farenheit");
        System.out.println("2 dla Farenheit->Celcius");
        System.out.println("3 aby dodac wlasny przelicznik jednostek");
        System.out.println("4-98 uruchomic wlasny przelicznik jednostek");
        System.out.println("99 aby wyjsc \n");
        System.out.println("100 aby zapisac obecne wlasne przeliczniki \n");
        
        String s = simpleInputScanning();
        return s;
    }
    
    /**
     *  gets console input from user
     * @return  string from console
     */
    public static String simpleInputScanning()
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }
      
    /**
     *  Prints out the standard response for celcius converter
     */
    public static void printOptionCelcius(){
         System.out.println("Wprowadz liczbe w stopniach Celciusza");
     }

    /**
     *  Prints out the standard response for farenheit converter
     */
    public static void printOptionFarenheit(){
         System.out.println("Wprowadz liczbe w stopniach Farenheita");
     }

    /**
     *  Prints out the standard response for user trying to enter wrong number in the slot choice
     */
    public static void printOptionAddWrongSlot(){
         System.out.println("Wprowadzono zla liczbe. Wracam do menu");             
     }

    /**
     *  Prints out instructions when selected the custom converter
     * @param converterList standard converter list
     * @param decision  in this case slot choice for the converter
     */
    public static void printOptionSelectedCustom(ConverterList converterList, int decision){
         String name = converterList.getConvertersArray().get(decision - 4).getName();
         float a = converterList.getConvertersArray().get(decision-4).getA();
         float b = converterList.getConvertersArray().get(decision-4).getB();
         String stringToPrint = "Wybrales opcje: " + name + " o wzorze: " + a + "x ";
         if(b >= 0){
             stringToPrint += "+ ";
         }
         stringToPrint += Float.toString(b);
         
         System.out.print(stringToPrint);
         System.out.println("\nWprowadz X:");
    }

    /**
     *  Prints X request for Ax+B equasion solving
     */
    public static void printCustomOutput(){
         System.out.println("Wprowadz X:");        
     }

    /**
     *  Instructs the user what he needs to put in console to insert a new converter
     */
    public static void printOptionAddCustom(){
         System.out.println("Wprowadz numer slotu do ktorego chcesz wprowadzic swoj przelicznik:");
         System.out.println("Przelicznik będzie miał formę A*x + B:");
         System.out.println("Wybranie slotu w ktorym juz jest wprowadzony przelicznik spowoduje jego nadpisanie");
         System.out.println("Numer musi byc w zakresie 4-98");
    }

    /**
     *  Prints out the request for a custom converters name
     */
    public static void printOptionAddCustomName(){
         System.out.println("Wprowadz nazwe swojego przelicznika");
    }

    /**
     *  Prints out the request for a custom converters A value in Ax+B
     */
    public static void printOptionAddCustomA(){
         System.out.println("Wprowadz swoje A w Ax + B.:");
         System.out.println("Liczba może być ujemna i zmiennoprzecinkowa");
    }

    
    /**
     *  Prints out the request for a custom converters B value in Ax+B
     */
    public static void printOptionAddCustomB(){
         System.out.println("Wprowadź swoje B w Ax + B ");
         System.out.println("Liczba może być ujemna i zmiennoprzecinkowa");
    }
     
}
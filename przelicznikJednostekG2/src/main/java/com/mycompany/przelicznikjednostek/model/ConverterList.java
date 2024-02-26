/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.model;

import static com.mycompany.przelicznikjednostek.model.IniFileHandler.parseIniFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pawel Golabek
 * Converter list class file
 **/

/**
*   Default class to hold list of custom converters
**/
public class ConverterList {
    private ArrayList<Converter> convertersArray;

    // Default constructor

    /**
     *  Default constructor
     */
    public ConverterList() {
        // Initialize the array with default constructors for each Converter
        convertersArray = new ArrayList<Converter>(95);
        for (int i = 0; i < 95; i++) {
            Converter tmpConverter = new Converter();
            this.convertersArray.add(tmpConverter);
        }
    }
        
//  private Converter[] convertersArray = new Converter[95]; // 4-98
        // Getter for convertersArray

    /**
     *  Basic getter for convertersArray 
     * @return returns standard converter array
     */
    public List<Converter> getConvertersArray() {
        return convertersArray;
    }

    /**
     *  Setter for convertersArray
     * @param convertersArray standard custom converter array
     */
    public void setConvertersArray(ArrayList<Converter> convertersArray) {
        this.convertersArray = convertersArray;
    }

    /**
     * I didn't know where to put my exception so I put it under IOException
     * Probably shouldn't be done this way but I had to put it somewhere so here it is
     * @param filename Name of a file / relative path
     * @throws MyException my exception for problems with .ini file
     * @throws IOException IO exception that throws my exception
     */
    public void loadConvertersFromFile(String filename) throws MyException, IOException{
        Map<String, Map<String, String>> iniData = parseIniFile(filename);
        
        Iterator<Map.Entry<String, Map<String, String>>> iterator = iniData.entrySet().iterator();

        while (iterator.hasNext()) {                                                        // clear map of any sections that are not converters
            Map.Entry<String, Map<String, String>> ini = iterator.next();
            String key;
            key = ini.getKey();

            if (!key.startsWith("converter")) {
                iterator.remove();                                                          // Remove the key-value pair from the map
            }
            else{
                String numberStr = key.replaceAll("converter", "");             // add element to custom converter list
                int slotNumber = Integer.parseInt(numberStr);
                Map<String, String> iniSection = ini.getValue();
                this.convertersArray.get(slotNumber).setA(Float.parseFloat(iniSection.get("A")));
                this.convertersArray.get(slotNumber).setB(Float.parseFloat(iniSection.get("B")));
                this.convertersArray.get(slotNumber).setName(iniSection.get("name"));
            }
        }    
    }
    
    /**
     * Used to replace default converter or a converter on a list to new one
     * based on the input
     * @param slot  designated number of converter
     * @param name  converter attribute; its name
     * @param A     converter attribute; its A in Ax+B
     * @param B     converter attribute; its B in Ax+B
     */
    public void newConverter(int slot, String name, float A, float B){
        Converter converter = new Converter(name, A, B);
        this.convertersArray.set(slot - 4, converter);
    }
    
        
}

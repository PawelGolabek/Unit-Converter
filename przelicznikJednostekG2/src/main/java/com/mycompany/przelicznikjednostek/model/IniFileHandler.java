/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Pawel Golabek
 */
/**
 *  Class made to read and write converter list to and from .ini file
 */
public class IniFileHandler {

    
    /**
     * Default constructor
     */
    IniFileHandler(){}
    
    /**
     * reads an .ini file from filename and returns it as a map with standard .ini map form
     * @param filename name of a .ini file
     * @return a map with standard .ini map form
     * @throws MyException my exception for problems with .ini file
     * @throws IOException IO exception that throws my exception
     */
    public static Map<String, Map<String, String>> parseIniFile(String filename) throws MyException, IOException {
        Map<String, Map<String, String>> iniData = new HashMap<>();
        String currentSection = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith(";") || line.startsWith("#")) {
                    continue; // Skip comments and empty lines
                }
                if (line.startsWith("[")) {
                    int endIndex = line.indexOf("]");
                    if (endIndex != -1) {
                        currentSection = line.substring(1, endIndex);
                        iniData.put(currentSection, new HashMap<>());
                    }
                } else {
                    if (currentSection != null) {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            String key = parts[0].trim();
                            String value = parts[1].trim();
                            iniData.get(currentSection).put(key, value);
                        }
                    }
                }
            }
        } catch (IOException e) {
            MyException.generateException("Cos nie tak z plikiem .ini (odczyt)");
        }

        return iniData;
    }
    
    /**
     * writes an .ini file from converter list with every converter having its section and attributes inside a section
     * @param converterList standard custom converterList object
     * @param filename name or relative path to an .ini file
     * @throws MyException my exception for problems with .ini file
     * @throws IOException IO exception that throws my exception
     */
    public static void writeIni(ConverterList converterList, String filename) throws MyException, IOException{
        List<Converter> converters;
        converters = converterList.getConvertersArray();
        int[] i = {0};

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
        converters.forEach(converter -> {
            try {
                writer.write("[converter" + i[0] + "]\n");
                writer.write("name = " + converter.getName() + "\n");
                writer.write("A = " + converter.getA() + "\n");
                writer.write("B = " + converter.getB() + "\n");
                i[0]++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
            } catch (IOException ex) {
                
                try {
                  MyException.generateException();
              } catch (MyException e) {
                  e.printStackTrace(); // Handle the standard exception here
              }
    
        }
    
    }

}





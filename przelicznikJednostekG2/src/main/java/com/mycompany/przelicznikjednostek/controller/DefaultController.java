/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.przelicznikjednostek.controller;
//
import com.mycompany.przelicznikjednostek.model.ConverterList;
import com.mycompany.przelicznikjednostek.model.DefaultModel;
import static com.mycompany.przelicznikjednostek.model.IniFileHandler.writeIni;
import com.mycompany.przelicznikjednostek.model.MyException;
import com.mycompany.przelicznikjednostek.view.DefaultView;
import static com.mycompany.przelicznikjednostek.view.DefaultView.printResult;
import static com.mycompany.przelicznikjednostek.view.DefaultView.simpleInputScanning;
import java.io.IOException;

/**
 *
 * @author Pawel Golabek
 * 
 */


/**
*  Default controller to manage basic program loop
*/
public class DefaultController {
    
    
    /**
     * Default Controller construuctor just in case I ever needed it
     */
    public DefaultController(){
    
    }
    /**
     * Main loop of a program
     * @param decision  converter choice for the console input
     * @param input number for the console input
     * @param consoleInput enum is equal to YES if lacking arguments in command line, NO otherwise
     * @param converterList used for saved converters from .ini
     * @throws MyException my exception for problems with .ini file
     * @throws IOException IO exception that throws my exception
     */
    public static void mainLoopF(int decision, float input, ConsoleInputEnumHandler consoleInput, ConverterList converterList) throws MyException, IOException{
      float result = -1;
      
      while(decision != 99){
        if (decision == 1) {
          if (consoleInput.getMyEnum() == ConsoleInputEnumHandler.IsConsoleInputOk.YES) {
                DefaultView.printOptionCelcius();
                input = Float.parseFloat(simpleInputScanning());
                }
                result = DefaultModel.calculateCelciusFarenheit(input);
                printResult(result);
                decision = -1;
          }else if (decision == 2) {
                if (consoleInput.getMyEnum() == ConsoleInputEnumHandler.IsConsoleInputOk.YES) {
                    DefaultView.printOptionFarenheit();
                    input = Float.parseFloat(simpleInputScanning());
                }
                result = DefaultModel.calcutateFarenheitCelcius(input);
                printResult(result);
                decision = -1;
          } else if (decision == 3) {                                   // add custom
                float inputA, inputB;
                int inputSlot;
                String inputName;
                DefaultView.printOptionAddCustom();
                inputSlot = Integer.parseInt(simpleInputScanning());
                if(inputSlot > 98 || inputSlot < 4){
                    DefaultView.printOptionAddWrongSlot();                    
                }else{
                    DefaultView.printOptionAddCustomName();
                    inputName = simpleInputScanning();
                    DefaultView.printOptionAddCustomA();
                    inputA = Float.parseFloat(simpleInputScanning());
                    DefaultView.printOptionAddCustomB();
                    inputB = Float.parseFloat(simpleInputScanning());
                    converterList.newConverter(inputSlot,inputName,inputA, inputB);
                    printResult(result);
                }
                decision = -1;
          } else if(decision >= 4 && decision <= 98){                   // use custom 
                DefaultView.printOptionSelectedCustom(converterList, decision);
                input = Float.parseFloat(simpleInputScanning());
                float output = converterList.getConvertersArray().get(decision-4).calculate(input);
                printResult(output);
                decision = -1;
            
          } else if(decision == 100){  
                writeIni(converterList,"src/savedConverters.ini");
                decision = -1;
            }
              
            else if (consoleInput.getMyEnum() == ConsoleInputEnumHandler.IsConsoleInputOk.NO) {
                decision = 99;
            } else {
                decision = Integer.parseInt(DefaultView.menu());          // menu for further steps in case of console input
            }
          }

    }
}

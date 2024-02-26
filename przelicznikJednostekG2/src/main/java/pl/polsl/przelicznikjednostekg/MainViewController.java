/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.przelicznikjednostekg;

import com.mycompany.przelicznikjednostek.model.Converter;
import com.mycompany.przelicznikjednostek.model.ConverterList;
import com.mycompany.przelicznikjednostek.model.DefaultModel;
import com.mycompany.przelicznikjednostek.model.IniFileHandler;
import com.mycompany.przelicznikjednostek.model.MyException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Pawel Golabek
 */
public class MainViewController implements Initializable{
    
/**
 * Represents the result label in the Converter application.
 */
@FXML
private Label result;

/**
 * Represents the input field for value 'a' in the Converter application.
 */
@FXML
private TextField aValue;

/**
 * Represents the table view displaying ConverterView objects in the Converter application.
 */
@FXML
private TableView<ConverterView> table;

/**
 * Represents the column for the 'Slot' property in the table view of the Converter application.
 */
@FXML
private TableColumn<ConverterView, Integer> SlotCol;

/**
 * Represents the column for the 'Name' property in the table view of the Converter application.
 */
@FXML
private TableColumn<ConverterView, String> nameCol;

/**
 * Represents the column for the 'A' property in the table view of the Converter application.
 */
@FXML
private TableColumn<ConverterView, Float> aCol;

/**
 * Represents the column for the 'B' property in the table view of the Converter application.
 */
@FXML
private TableColumn<ConverterView, Float> bCol;

/**
 * Represents a tooltip element (tooltip) in the Converter application.
 */
@FXML
private Tooltip test;

/**
 * Represents the Celsius button in the Converter application.
 */
@FXML
private Button celciusButt;

/**
 * Represents the Fahrenheit button in the Converter application.
 */
@FXML
private Button farenheitButt;

/**
 * Represents the root element (anchor pane) in the Converter application.
 */
@FXML
private AnchorPane root;

/**
 * Represents the input field for the 'slot' value in the Converter application.
 */
@FXML
private TextField slot;

/**
 * Represents the input field for the 'A' value in the Converter application.
 */
@FXML
private TextField aConverter;

/**
 * Represents the input field for the 'B' value in the Converter application.
 */
@FXML
private TextField bConverter;

/**
 * Represents the input field for the converter name in the Converter application.
 */
@FXML
private TextField nameConverter;

/**
 * Represents the button to reset converters in the Converter application.
 */
@FXML
private Button resetConvertersButton;

/**
 * Represents the button to save converters in the Converter application.
 */
@FXML
private Button saveConvertersButton;

/**
 * Represents the button to add converters in the Converter application.
 */
@FXML
private Button addConverterButton;


    /**
     *
     * @param event
     */
    public void buttonClick(ActionEvent event){
        
        
    }
/**
 * Initializes the ConverterView by setting up the cell value factories and populates the table with converters.
 * 
 * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
 * @param rb  The resources used to localize the root object, or null if the root object was not localized.
 */
@Override
public void initialize(URL url, ResourceBundle rb) {
    SlotCol.setCellValueFactory(new PropertyValueFactory<ConverterView, Integer>("slot"));
    nameCol.setCellValueFactory(new PropertyValueFactory<ConverterView, String>("name"));
    aCol.setCellValueFactory(new PropertyValueFactory<ConverterView, Float>("A"));
    bCol.setCellValueFactory(new PropertyValueFactory<ConverterView, Float>("B"));
    try {
        table.setItems(getConverters());
    } catch (MyException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

/**
 * Retrieves converters from a file and generates an ObservableList of ConverterView objects.
 * 
 * @return An ObservableList of ConverterView objects.
 * @throws MyException If an error occurs while handling converters.
 * @throws IOException If an I/O error occurs when reading from the file.
 */
public ObservableList<ConverterView> getConverters() throws MyException, IOException {
    ObservableList<ConverterView> converters = FXCollections.observableArrayList();
    ConverterList converterList = new ConverterList();
    converterList.loadConvertersFromFile("src/savedConverters.ini");
    
    int slot;
    String name;
    float A;
    float B;
    int i = 4;
    for (Converter a : converterList.getConvertersArray()) {
        slot = i;
        name = a.getName();
        A = a.getA();
        B = a.getB();
        converters.add(new ConverterView(slot, name, A, B));            
        i += 1;
    }
    
    return converters;
}

/**
 * Saves converters to a specified file.
 * 
 * @param filename The name of the file to save converters to.
 * @throws MyException If an error occurs while handling converters.
 * @throws IOException If an I/O error occurs when writing to the file.
 */
public void saveConverters(String filename) throws MyException, IOException {
    ConverterList converterList = new ConverterList();
    ObservableList<ConverterView> dataList = table.getItems();
    ArrayList<Converter> newConverterList = new ArrayList<>();
    for (ConverterView con : dataList) {
        Converter converter = new Converter();
        converter.setName(con.getName());
        converter.setA(con.getA());
        converter.setB(con.getB());
        newConverterList.add(converter);    
    }
    converterList.setConvertersArray(newConverterList);
    IniFileHandler.writeIni(converterList, filename);
}
/**
 * Handles events related to user interaction in the Converter application.
 */
@FXML
private void tableClicked(MouseEvent event) throws MyException, IOException {
    ConverterList converterList = new ConverterList();
    converterList.loadConvertersFromFile("src/savedConverters.ini");
    ConverterView selectedItem = table.getSelectionModel().getSelectedItem();
    if (aValue.getText().isEmpty()) {
        result.setText("0");
    } else {
        float a = Float.parseFloat(aValue.getText());
        float toShow = DefaultModel.calculateCustom(a, converterList.getConvertersArray().get(selectedItem.getSlot() - 4));
        result.setText("" + toShow);
    }
}

/**
 * Method triggered by mouse event on the Celsius button.
 * (No specific functionality provided in the method body.)
 *
 * @param event The MouseEvent associated with the action.
 */
@FXML
private void celciusButton(MouseEvent event) {
    // Method body intentionally left blank.
}

/**
 * Calculates and displays the Celsius to Fahrenheit conversion result
 * when triggered by an ActionEvent from the Celsius button.
 *
 * @param event The ActionEvent associated with the action.
 */
@FXML
private void celciusButtonFunc(ActionEvent event) {
    float toShow = 0;
    if (!aValue.getText().isEmpty()) {
        toShow = DefaultModel.calculateCelciusFarenheit(Float.parseFloat(aValue.getText()));
    }
    result.setText("" + toShow);
}

/**
 * Calculates and displays the Fahrenheit to Celsius conversion result
 * when triggered by an ActionEvent.
 *
 * @param event The ActionEvent associated with the action.
 */
private void farenheitButtonFunc(ActionEvent event) {
    float toShow = 0;
    if (!aValue.getText().isEmpty()) {
        toShow = DefaultModel.calcutateFarenheitCelcius(Float.parseFloat(aValue.getText()));
    }
    result.setText("" + toShow);
}

/**
 * Focuses on the root element of the application window
 * when triggered by a MouseEvent.
 *
 * @param event The MouseEvent associated with the action.
 */
@FXML
private void focusRoot(MouseEvent event) {
    root.requestFocus();
}

    @FXML
    private void handleInputs(KeyEvent event) {
        
        if (event.getCode() != null) { 
            if (event.getCode() == KeyCode.I) {
                aValue.requestFocus();
                return;
            }
            if (event.getCode() == KeyCode.Q) {
                slot.requestFocus();
                return;
            }
            if (event.getCode() == KeyCode.W) {
                nameConverter.requestFocus();
                return;
            }
            if (event.getCode() == KeyCode.E) {
                aConverter.requestFocus();
                return;
            }
            if (event.getCode() == KeyCode.R) {
                bConverter.requestFocus();
                return;
            }
            
            if (event.getCode() == KeyCode.F) {
                farenheitButt.fire();
            } else if (event.getCode() == KeyCode.ESCAPE) {
                root.requestFocus();
            } else if (event.getCode() == KeyCode.C) {
                celciusButt.fire();
            } else if (event.getCode() == KeyCode.D) {
                addConverterButton.fire();
            } else if (event.getCode() == KeyCode.Z) {
                saveConvertersButton.fire();
            } else if (event.getCode() == KeyCode.L) {
                resetConvertersButton.fire();
            }
        }
    }
/**
 * Represents the method triggered by a KeyEvent on the Fahrenheit button. 
 * (Method body intentionally left blank.)
 *
 * @param event The KeyEvent associated with the action.
 */
@FXML
private void farenheitButtonFunc(KeyEvent event) {
    // Method body intentionally left blank.
}

/**
 * Represents the method triggered by a MouseEvent on the saveConvertersButton,
 * used to save converter data to a file.
 *
 * @param event The MouseEvent associated with the action.
 * @throws MyException If an error occurs while handling converters.
 * @throws IOException If an I/O error occurs when writing to the file.
 */
@FXML
private void saveConvertersButtonFunc(MouseEvent event) throws MyException, IOException {
    try {
        saveConverters("src/savedConverters.ini");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

/**
 * Represents the method triggered by a MouseEvent on the addButton,
 * used to add new converter data to the table.
 *
 * @param event The MouseEvent associated with the action.
 */
@FXML
private void addButton(MouseEvent event) {
    ObservableList<ConverterView> tableData = table.getItems();
    try {
        float A = Float.parseFloat(aConverter.getText());
        float B = Float.parseFloat(bConverter.getText());
        String name = nameConverter.getText();

        ConverterView converter = tableData.get(Integer.parseInt(slot.getText()) - 4);
        converter.setA(A);
        converter.setB(B);
        converter.setName(name);
        table.refresh();

    } catch (NumberFormatException e) {
        // Handle exception if there are issues with number formatting.
    }
}

/**
 * Resets the converters table based on MouseEvent.
 * 
 * @param event The MouseEvent triggering the method
 */
@FXML
private void resetConvertersButtonFunc(MouseEvent event) {
    try {
        table.getItems().clear(); // Clear the table data directly
        
        SlotCol.setCellValueFactory(new PropertyValueFactory<>("slot"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        aCol.setCellValueFactory(new PropertyValueFactory<>("A"));
        bCol.setCellValueFactory(new PropertyValueFactory<>("B"));
        
        table.setItems(getConverters()); // Set new items after clearing
    } catch (MyException | IOException ex) {
        ex.printStackTrace();
        // Handle exceptions as needed
    }
}

/**
 * Resets the converters table based on ActionEvent.
 * 
 * @param event The ActionEvent triggering the method
 */
@FXML
private void resetConvertersButtonFuncA(ActionEvent event) {
    try {
        table.getItems().clear(); // Clear the table data directly
        
        SlotCol.setCellValueFactory(new PropertyValueFactory<>("slot"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        aCol.setCellValueFactory(new PropertyValueFactory<>("A"));
        bCol.setCellValueFactory(new PropertyValueFactory<>("B"));
        
        table.setItems(getConverters()); // Set new items after clearing
    } catch (MyException | IOException ex) {
        ex.printStackTrace();
        // Handle exceptions as needed
    }
}

/**
 * Saves converters to a specified file.
 * 
 * @param event The ActionEvent triggering the method
 * @throws MyException If an exception specific to the application occurs
 */
@FXML
private void saveConvertersButtonFuncA(ActionEvent event) throws MyException {
    try {
        saveConverters("src/savedConverters.ini");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

/**
 * Adds a converter based on user input to the table.
 * 
 * @param event The ActionEvent triggering the method
 */
@FXML
private void addConverterButtonA(ActionEvent event) {
    ObservableList<ConverterView> tableData = table.getItems();
    try {
        float A = Float.parseFloat(aConverter.getText());
        float B = Float.parseFloat(bConverter.getText());
        String name = nameConverter.getText();
        
        ConverterView converter = tableData.get(Integer.parseInt(slot.getText()) - 4);
        converter.setA(A);
        converter.setB(B);
        converter.setName(name);
        table.refresh(); 
    } catch (NumberFormatException e) {
        // Handle NumberFormatException as needed
    }
}

/**
 * Converts a value from Celsius to Fahrenheit and displays the result.
 * 
 * @param event The ActionEvent triggering the method
 */
@FXML
private void farenheitButtonFuncA(ActionEvent event) {
    float toShow = 0;
    if (aValue.getText().isEmpty()) {
        // Handle empty input
    } else {
        toShow = DefaultModel.calcutateFarenheitCelcius(Float.parseFloat(aValue.getText()));
    }
    result.setText("" + toShow);
}

/**
 * Resets the converters table based on a key event.
 * 
 * @param event The KeyEvent triggering the method
 */
@FXML
private void resetConvertersButtonFuncKey(KeyEvent event) {
    try {
        table.getItems().clear(); // Clear the table data directly
        
        SlotCol.setCellValueFactory(new PropertyValueFactory<>("slot"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        aCol.setCellValueFactory(new PropertyValueFactory<>("A"));
        bCol.setCellValueFactory(new PropertyValueFactory<>("B"));
        
        table.setItems(getConverters()); // Set new items after clearing
    } catch (MyException | IOException ex) {
        ex.printStackTrace();
        // Handle exceptions as needed
    }
}

}

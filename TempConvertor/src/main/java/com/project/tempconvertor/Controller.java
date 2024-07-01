package com.project.tempconvertor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox choiceBox;

    @FXML
    public TextArea userinput;
    @FXML
    public Button convertId;
    private static final String C_To_F_TEXT="Celsius to Farenheit";
    private static final String F_To_C_TEXT="Farenheit to Celsius";

    private boolean isC_TO_F=true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox.getItems().add(C_To_F_TEXT);
        choiceBox.getItems().add(F_To_C_TEXT);
        //default value
        choiceBox.setValue(C_To_F_TEXT);
        //response to click listener
        // change in lamba expression after the click
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) ->
        {
            System.out.println(t1);
            if(t1.equals(C_To_F_TEXT))
            {
                isC_TO_F=true;
            } else {
                isC_TO_F=false;
            }

        });

        //changed in lambda expression
        convertId.setOnAction(actionEvent ->
        {
//          System.out.println("Button Clicked");
            convert();
        });
    }

    private void convert() {
        //23.5->"23.5"
        float enteredTemp=0.0f;
        String input= userinput.getText();// input as a string so we changed in number
        try {
            enteredTemp = Float.parseFloat(input); //23.5f
        } catch(Exception Ex)
        {
            warnUser();
            return ;
        }
        float newTemp=0.0f;
        if(isC_TO_F)
        {
            newTemp=(enteredTemp*9/5)+32;
        }
        else
        {
            newTemp=(enteredTemp -32)*5/9;
        }
        display(newTemp);
    }

    private void warnUser() {
        Alert alert= new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperatur Entered");
        alert.setContentText("Please enter a Valid Temp ");
        alert.show();
    }

    private void display(float newTemp) {
        String unit =isC_TO_F?" F": "C";
        System.out.println(" The New Temperature is : " + newTemp + unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText(" The New Temperature is : " + newTemp + unit);
        alert.show();
    }
}

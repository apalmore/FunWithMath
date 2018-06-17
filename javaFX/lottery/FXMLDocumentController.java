/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.austinpalmore.fun_with_math.javaFX.lottery;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label_1;
    @FXML
    private Label label_2;
    @FXML
    private Label label_3;
    @FXML
    private Label label_4;
    @FXML
    private Label label_5;
    @FXML
    private Label label_6;
    @FXML
    private Spinner spinner1;
    @FXML
    private Spinner spinner2;
    @FXML
    private Spinner spinner3;
    @FXML
    private Spinner spinner4;
    @FXML
    private Spinner spinner5;
    @FXML
    private Spinner spinner6;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    public void spin(ActionEvent event){
        Random rand = new Random();
        int[] randints = new int[6];
        int[] submit = new int[6];
        for (int i = 0;i < randints.length;i++)
            randints[i] = rand.nextInt(65) + 1;
        label_1.setText(Integer.toString(randints[0]));
        label_2.setText(Integer.toString(randints[1]));
        label_3.setText(Integer.toString(randints[2]));
        label_4.setText(Integer.toString(randints[3]));
        label_5.setText(Integer.toString(randints[4]));
        label_6.setText(Integer.toString(randints[5]));
        submit[0] = (int)spinner1.getValue();
        submit[1] = (int)spinner2.getValue();
        submit[2] = (int)spinner3.getValue();
        submit[3] = (int)spinner4.getValue();
        submit[4] = (int)spinner5.getValue();
        submit[5] = (int)spinner6.getValue();
            int match = 0;
        for(int i = 0;i < submit.length;i++) {
            if(randints[i] == submit[i]) match++;
        }
        if(match == 0) System.out.println("Not Even One Number");
        else if(match == 1) System.out.println("Your not a complete loser one match");
        else if (match < 4) System.out.println("Not Bad " + match + " Numbers match");
        else if (match == 5) System.out.println("You almost became very ritch");
        else if (match == 6) System.out.println("This will never actualy happen");
    }
    public void randompick(ActionEvent event){
        Random rand = new Random();
        spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        spinner6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
    }    
    
}

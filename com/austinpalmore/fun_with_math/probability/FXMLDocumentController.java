/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.austinpalmore.fun_with_math.probability;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.Random;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
/*
 *
 * @author User
 */
@SuppressWarnings("rawtypes")
public class FXMLDocumentController implements Initializable {
    @FXML Label Label_1;
    @FXML Label Label_2;
    @FXML Label Label_3;
    @FXML Label Label_4;
    @FXML Label Label_5;
    @FXML Label Label_6;
    @FXML Label Submited;
    @FXML Spinner Pick_1;
    @FXML Spinner Pick_2;
    @FXML Spinner Pick_3;
    @FXML Spinner Pick_4;
    @FXML Spinner Pick_5;
    @FXML Spinner Pick_6;
    
    public void spin(ActionEvent event){
        Random rand = new Random();
        int[] randints = new int[6];
        int[] submit = new int[6];
        for (int i = 0;i < randints.length;i++)
            randints[i] = rand.nextInt(65) + 1;
        Label_1.setText(Integer.toString(randints[0]));
        Label_2.setText(Integer.toString(randints[1]));
        Label_3.setText(Integer.toString(randints[2]));
        Label_4.setText(Integer.toString(randints[3]));
        Label_5.setText(Integer.toString(randints[4]));
        Label_6.setText(Integer.toString(randints[5]));
        submit[0] = (int)Pick_1.getValue();
        submit[1] = (int)Pick_2.getValue();
        submit[2] = (int)Pick_3.getValue();
        submit[3] = (int)Pick_4.getValue();
        submit[4] = (int)Pick_5.getValue();
        submit[5] = (int)Pick_6.getValue();
        int match = 0;
        for(int i = 0;i < submit.length;i++) {
            if(randints[i] == submit[i]) match++;
        }
        if(match == 0) Submited.setText("Not Even One Number");
        else if(match == 1) Submited.setText("Your not a complete loser one match");
        else if (match < 4) Submited.setText("Not Bad " + match + " Numbers match");
        else if (match == 5) Submited.setText("You almost became very ritch");
        else if (match == 6) Submited.setText("This will never actualy happen");
        
    }
    @SuppressWarnings("rawtypes")
    public void newRandomPick(ActionEvent event){
        Random rand = new Random();
	@SuppressWarnings("unchecked")
	this.Pick_1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
    }
    @SuppressWarnings("rawtypes")
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        this.Pick_1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
        this.Pick_6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,65,rand.nextInt(65) + 1));
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knack_den_code;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author manueleberts
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textFeld1;
    private AnchorPane farbauswahl;
    private Button button1_1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        textFeld1.setText("Wählen sie eine Farbe aus!");
        button1_1.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

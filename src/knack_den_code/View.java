/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knack_den_code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Friedrich
 */
public class View extends Application {

    TextField textField;
    Controller controller;

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 300, 250);
        textField = new TextField("Geben Sie bitte einen Befehl ein");
        textField.setMaxSize(Double.MAX_VALUE, 30);
        Button start = new Button("Start");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                starten();
            }

        });
        root.getChildren().add(textField);
        root.getChildren().add(start);

        primaryStage.setTitle("Knack den Code");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void starten() {
//        controller = new Controller(this);
//        controller.spiele("zeigeFeld");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void ausgeben(String s) {
        textField.setText(s);
    }
}

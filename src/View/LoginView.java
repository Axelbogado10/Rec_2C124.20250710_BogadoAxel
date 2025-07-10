/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author bogad
 */
import Modelo.Vendedor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import javafx.geometry.Insets;

public class LoginView extends VBox {

    public LoginView(Stage stage, HashMap<String, Vendedor> cuentas) {

        Label mensaje = new Label("Ingrese nombre de usuario y PIN:");
        
        Button btnIngresar = new Button("Ingresar");
        
        Button btnVendedors = new Button("Vendedors - DEBUG");
       
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre de usuario");
        
        PasswordField campoPin = new PasswordField();
        campoPin.setPromptText("PIN");

        btnIngresar.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String pin = campoPin.getText();

            Vendedor cuenta = cuentas.get(nombre);
            if (cuenta != null && cuenta.ValidarPin(pin)) {
                MenuView menu = new MenuView(stage, cuenta, cuentas);
                stage.setScene(new Scene(menu));
            } else {
                mensaje.setText("ERROR: usuario o pin incorrecto.");
            }
        });

        btnVendedors.setOnAction(e-> {
                System.out.println("Vendedors cargadas: " + cuentas); // Debug

        });
        getChildren().addAll(mensaje, campoNombre, campoPin, btnIngresar, btnVendedors);
        setSpacing(10);
        setPadding(new Insets(10));
    }
}
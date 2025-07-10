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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import javafx.geometry.Insets;

public class MenuView extends VBox {

    public MenuView(Stage stage, Vendedor cuenta, HashMap<String, Vendedor> cuentas) {
        Label bienvenida = new Label("Bienvenido al sistema.");
        Button btnConsult = new Button("Consultar ventas");
        Button btnVender = new Button("Vender entradas");
        Button btnPrecio = new Button("Mostrar precio actual de entradas");
        Button btnSalir = new Button("Salir");

        btnConsult.setOnAction(e -> {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION,
                    "Entradas vendidas: " + cuenta.getTpasajesVendidos());
            alerta.showAndWait();
        });

        btnVender.setOnAction(e -> {
            VentaView operacion = new VentaView(stage, cuenta, cuentas);
            stage.setScene(new Scene(operacion));
        });

        btnPrecio.setOnAction(e -> {
            Alert alertaPrecio = new Alert(Alert.AlertType.INFORMATION,
                    "Precio actual: $" + cuenta.getPrecio());
            alertaPrecio.showAndWait();
        });

        btnSalir.setOnAction(e -> {
            LoginView login = new LoginView(stage, cuentas);
            stage.setScene(new Scene(login));
        });

        getChildren().addAll(bienvenida, btnConsult, btnVender, btnPrecio, btnSalir);
        setSpacing(10);
        setPadding(new Insets(10));
        setStyle("-fx-padding: 20; -fx-alignment: center;");
    }
}
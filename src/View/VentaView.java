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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import javafx.geometry.Insets;

public class VentaView extends VBox {

    public VentaView(Stage stage,Vendedor cuenta, HashMap<String,Vendedor> cuentas) {

        Label lbl = new Label("Ingrese Origen, Destino y la cantidad de entradas a vender:");
        
        TextField campoOrigen = new TextField();
        campoOrigen.setPromptText("Origen");
        
        TextField campoDestino = new TextField();
        campoDestino.setPromptText("Destino");
        
        TextField campoMonto = new TextField();
        campoMonto.setPromptText("Cantidad");
        
        Button btnAceptar = new Button("Aceptar");
        
        Button btnCancelar = new Button("Cancelar");
        
        Label resultado = new Label();

        btnAceptar.setOnAction(e -> {
            try {
                String origen = campoOrigen.getText();
                String destino = campoDestino.getText();
                int monto = Integer.parseInt(campoMonto.getText());
                
                if(origen.isEmpty() || destino.isEmpty() || monto < 0 ){
                    lbl.setText("todos los campos son obligatorios");
                    return;
                }
                
                cuenta.VentasP(monto);
                lbl.setText("Venta exitosa");
                resultado.setText("Entradas vendidas: "+ monto + " por " +  cuenta.precioxventas(monto));
                //si no ve el precio por las ventas tiene que ampliar un poco la ventana, esta abajo del todo.
            } catch (NumberFormatException ex) {
                resultado.setText("Error: ingrese un número válido.");
            }
            campoMonto.clear();
            campoOrigen.clear();
            campoDestino.clear();
        });


        btnCancelar.setOnAction(e -> {
            MenuView menu = new MenuView(stage, cuenta, cuentas);
            stage.setScene(new Scene(menu));
        });

        getChildren().addAll(lbl, campoOrigen, campoDestino, campoMonto, btnAceptar, btnCancelar, resultado);
        setSpacing(10);
        setPadding(new Insets(10));
        setStyle("-fx-padding: 20; -fx-alignment: center;");
    }
}
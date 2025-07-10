/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial2;

/**
 *
 * @author bogad
 */
import Modelo.Vendedor;
import Persistencia.PersistirVentas;
import View.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import static javafx.application.Application.launch;

public class Parcial2 extends Application {

    

    public static void main(String[] args) {
        launch(args); // Lanza la aplicación JavaFX
    }

    @Override
    public void start(Stage stage) throws Exception {
        HashMap<String, Vendedor> cuentas = PersistirVentas.cargar();

        // LoginView ahora debería recibir el mapa de cuentas
        LoginView login = new LoginView(stage, cuentas);

        stage.setScene(new Scene(login));
        stage.setTitle("Sistema de Ventas - inicio de sesion");

        stage.setOnCloseRequest(e -> PersistirVentas.guardar(cuentas));
        stage.show();
    }
}
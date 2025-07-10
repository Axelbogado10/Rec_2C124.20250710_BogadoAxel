/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author bogad
 */

import Modelo.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class PersistirVentas {
    public static final String ARCHIVO = "cuenta.dat";
    
public static HashMap<String, Vendedor> cargar() {
    File archivo = new File(ARCHIVO);
    if (!archivo.exists()) {
        HashMap<String, Vendedor> cuentas = new HashMap<>();
            cuentas.put("usuario1", new Vendedor("1111", "usuario1", 10, 1000,10));
            cuentas.put("usuario2", new Vendedor("5555", "usuario2", 5, 750,10));
        return cuentas;
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
        return (HashMap<String, Vendedor>) ois.readObject();
    } catch (IOException | ClassNotFoundException ioe) {
        System.out.println("Error cargando cuenta:" + ioe.getMessage());
        HashMap<String, Vendedor> cuentas = new HashMap<>();
            cuentas.put("usuario1", new Vendedor("1111", "usuario1", 10, 1000,10));
            cuentas.put("usuario2", new Vendedor("5555", "usuario2", 5, 750,10));
        return cuentas;
    }
}

    
    public static void guardar(HashMap<String, Vendedor> cuentas) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
        oos.writeObject(cuentas);
    } catch (IOException ioe) {
        System.out.println("Error guardando cuentas: " + ioe.getMessage());
    }
}
}
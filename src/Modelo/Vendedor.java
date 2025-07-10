/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bogad
 */
import java.io.Serializable;

public class Vendedor implements Serializable{
private String contraseña;
private String usuario;
private int TpasajesVendidos;
private int Pvendidos;
private int precio;

    public Vendedor(String contraseña, String usuario, int Pvendidos, int precio, int TpasajesVendidos) {
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.Pvendidos = Pvendidos;
        this.precio = precio;
        this.TpasajesVendidos = TpasajesVendidos;
    }

    public String getContraseña() {
        return contraseña;
    }
   
    
    public String getUsuario() {
        return usuario;
    }

    public int getTpasajesVendidos() {
        return TpasajesVendidos;
    }

    
    
    public int getPvendidos() {
        return Pvendidos;
    }

    public int getPrecio() {
        return precio;
    }

    public int precioxventas(int Pvendidos){
        return Pvendidos * precio;  
    }
    
    public void VentasP(int Pvendidos) {
      if(Pvendidos > 0){
        TpasajesVendidos += Pvendidos;
          System.out.println("venta exitosa" + TpasajesVendidos);   
        }else{ 
          System.out.println("no se pudo hacer la venta");
    }

}
    public boolean ValidarPin (String contraseña) {
        return this.contraseña.equals(contraseña);
    }
    
    public boolean ValidarUsuario ( String usuario) {
        return this.usuario.equals(usuario);
    }
    
@Override
    public String toString() {
    return "Cuenta{" +
           "nombre='" + usuario+ '\'' +  // Asegúrate de que estos campos existan en tu clase
           ", pin='" + contraseña + '\'' +
           ", ventas=" + Pvendidos +
           ", precio=" + precio +
           '}';
}
}
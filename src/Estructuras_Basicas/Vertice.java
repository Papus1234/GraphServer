/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_Basicas;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author usuario
 */
public class Vertice {
    String nombre;
    public List<Arista> aristas = new ArrayList<Arista>();
    
    
    
    public Vertice(String n){
        nombre=n;
    }
    
    public String getNombre(){
        return nombre;
    }
}

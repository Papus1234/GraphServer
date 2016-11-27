/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.|
 */
package Estructuras_Basicas;
import Objetos.Mensaje;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author usuario
 */
public class Vertice {
    String nombre;
    public List<Arista> aristas = new ArrayList<Arista>();
    List<Mensaje>listMsj=new ArrayList<>();

    
    public Vertice(String n){
        nombre=n;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public List<Mensaje> getListMsj() {
        return listMsj;
    }

    public void setListMsj(List<Mensaje> listMsj) {
        this.listMsj = listMsj;
    }
    

}

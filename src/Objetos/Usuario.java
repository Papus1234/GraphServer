/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Usuario {
    List<Mensaje>listMsj;
    String nombre;

    public Usuario(String nombre) {
        listMsj=new ArrayList<>();
        this.nombre = nombre;
        
    }

    
    
    public List<Mensaje> getListMsj() {
        return listMsj;
    }

    public void setListMsj(List<Mensaje> listMsj) {
        this.listMsj = listMsj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}

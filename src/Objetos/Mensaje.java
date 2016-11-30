/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Estructuras_Basicas.Arista;
import Estructuras_Basicas.Vertice;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class Mensaje {
    private String autor;
    private String mensaje;
    private String destinatario;
    private Date fecha;
    private List<Arista>listV;
    public Mensaje(){
        
        
    }

    public Mensaje(String autor, String mensaje, String destinatario, Date fecha,List<Arista>listV) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.listV=listV;
    }
     public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String darDijistra(){
        String aux="";
        for(int i=0; i<listV.size(); i++){//adhiere vertices de la ruta
            if(i==listV.size()-1){
            aux+=listV.get(i).getV2().getNombre();
            
            }else{
                
            aux+=listV.get(i).getV2().getNombre()+",";   
            
            } 
               
        }
        return aux;
    }

}

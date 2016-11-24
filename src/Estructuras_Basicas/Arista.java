/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_Basicas;

/**
 *
 * @author usuario
 */
public class Arista {
    public int peso;
    public Vertice segundoVertice; //vertice a donde se dirige la arista
    
    public Arista(int peso, Vertice v1, Vertice v2){
        this.peso=peso;
        this.segundoVertice=v2;
        v1.aristas.add(this);
    }
    
    @Override
    public String toString(){
                return " to " + segundoVertice;
        }
}

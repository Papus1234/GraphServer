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
    Vertice v1;
    Vertice v2;
    
    public Arista(int peso, Vertice v1, Vertice v2){
        this.peso=peso;
        this.segundoVertice=v2;
        v1.aristas.add(this);
        this.v1=v1;
        this.v2=v2;
    }
    
    
    @Override
    public String toString(){
                return " to " + segundoVertice;
        }
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }
    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

}

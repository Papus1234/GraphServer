/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_Basicas;

/**
 *
 * @author Roberto
 */
public class Arco {
    Vertice v1;
    Vertice v2;
    String peso;

    public Arco(Vertice v1, Vertice v2, String peso) {
        this.v1 = v1;
        this.v2 = v2;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
}

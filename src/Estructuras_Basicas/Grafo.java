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
public class Grafo {
    public Vertice vertices[];
    public int matrizAd[][];
    public int numVertices;
    public int maxVertices;
    
    
    public Grafo(int n){
        maxVertices=n;
        numVertices=0;
        vertices= new Vertice[maxVertices];
        matrizAd=new int[maxVertices][maxVertices];
        for(int i=0; i<maxVertices; i++){
            for(int j=0; j<maxVertices; j++){
                matrizAd[i][j]=99999;
            }
        }
    }
   
    public int getIndice(Vertice v){
        for (int i=0; i< numVertices; i++){
            if(v.getNombre()== vertices[i].getNombre()){
                return i;
            }
        }
        return -1;//Si no encuentra el vertice retorna un -1
    }
    
    public boolean estaVertice(Vertice v){
        return getIndice(v)!=-1;
    }
    
    public String toString(){
        String s= "";
        for(int i=0;i<numVertices; i++){
            s=s+"(";
            for(int j=0; j<numVertices; j++){
                
                s=s+matrizAd[i][j]+",";
            }
            s=s+")";
        }
        return s;
    }
    
    public void agregarVertice(Vertice v){
        if (estaVertice(v)==false){
            if(numVertices==0){
                vertices[0]=v;
                numVertices++;
            }
            else{
                
                for(int i=0; i<maxVertices; i++){
                   if(vertices[i]==null){
                       
                       vertices[i]=v;
                       numVertices++;
                        break;
                   }
                }
            }
        }
    }
    public List<Vertice> darArrayVertices(){
        List<Vertice> sandia=new ArrayList<>();
        for (int i=0; i<this.vertices.length; i++){
           if (this.vertices[i]!=null){
               sandia.add(this.vertices[i]);
           }
            
        }
        return sandia;
    }
     public List<Arista> obtenerArcos(){
        List<Arista>resp=new ArrayList <>();
        for (int i=0;i<this.matrizAd.length;i++){
            for (int j=0;j<this.matrizAd.length;j++){
                if (matrizAd[i][j]!=0){
                    if (matrizAd[i][j]<99999){
                        Vertice v1=this.vertices[i];
                        Vertice v2=this.vertices[j];
                        int peso=this.matrizAd[i][j];
                        resp.add(new Arista(peso, v1,v2));
                        
                    }
                }
            }
        }
        return resp;
    }
     
    
    public void agregarArco(int peso, Vertice v1, Vertice v2){
       for(int i=0;i<numVertices; i++){
           if(v1.getNombre()== vertices[i].getNombre()){
               for(int j=0;j<numVertices; j++){
                   if(v2.getNombre()== vertices[j].getNombre()){
                       matrizAd[i][j]=peso;
                       Arista aux= new Arista(peso, v1, v2);
                   }
               }
           }
       }    
    }
    
    public boolean adyacentes(Vertice v1, Vertice v2){
        for(int i=0;i<numVertices; i++){
           if(v1.getNombre()== vertices[i].getNombre()){
               for(int j=0;j<numVertices; j++){
                   if(v2.getNombre()== vertices[j].getNombre()){
                       return matrizAd[i][j]>0;
                   }
               }
           }
        }
        return false;
    }
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras_Basicas;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class Dijkstra {
    public int mCostos[][]; //Aquí se guarda la matriz de costos
    public Vertice ultimo[];//Guarda el último índice visitado
    public int CostoMin[];//Guarda el costo para llegar a cada vertice
    public boolean VertVisit[];//Muestra si un vertice ha sido visitado o no
    public int origInd, numVertices;//guarda el número de vértices y el pindice del vertice de origen
    public Vertice orig;//es el vertice de origen
    public Camino ruta;//guarda la ruta para llegar a un nodo
    public Grafo grafo;//guarda el grafo
    public Vertice from;//es un auxiliar que permite ir recorriendo cada nodo
    
    Map<String,Integer> analyzedPaths = new HashMap<String, Integer>(); // variable auxiliar que utiliza llaves para conseguir la información, va guardando una ruta y pesos
    
    public Dijkstra(Vertice orig, Grafo g ){//La entrada es un vertice de origen, y el grafo
        numVertices=g.numVertices;
        this.orig=orig;
        this.origInd=g.getIndice(orig);
        mCostos=g.matrizAd;
        CostoMin=new int[numVertices];
        VertVisit=new boolean[numVertices];
        ultimo=new Vertice[numVertices];
        ruta=null;
        grafo=g;
        from=orig;
        
    }
    
    public void caminoCorto(){//Calcula el costo mínimo para llegar a cada nodo
        for(int i=0; i<numVertices; i++){
            VertVisit[i]=false;//Inicia los nodos como no visitados
            CostoMin[i]=mCostos[origInd][i];//el peso directo del vertice de origen a los otros nodos
            ultimo[i]=orig;
        }
        
        VertVisit[origInd]=true;//Como se está visitando el nodo, se vuelve true
        CostoMin[origInd]=0;//Como se está en ese nodo, el costo para llegar a el mismo es cero
        for(int i=0; i<numVertices; i++){
            int min=minimo();//selecciona el vertice de menor distancia
            VertVisit[min]=true;
            for(int x=0; x<numVertices; x++){
                if(!VertVisit[x]){
                    if(CostoMin[min]+mCostos[min][x]<CostoMin[x]){
                        CostoMin[x]=CostoMin[min]+mCostos[min][x];  
                        x=min;
                        
                    }
                }
            } 
        }
        for (int i=0; i<numVertices; i++){ //imprime el costo a cada nodo
            System.out.print("costo mínimo a "+i+":"+CostoMin[i]+"\n");
        }
        
    }
    
    public void ruta(Vertice dest, Camino camino){ //calcula la ruta más corta del origen hacia otro nodo, funciona recursivamente
        if(from.nombre.equals(dest.nombre)){//detiene el ciclo si el vertice es igual al vertice de llegada
                        return;
                }
        for(Arista arista : from.aristas){
            Camino newRuta = new Camino();//se crea un nuevo camino donde se va a trabajar
            if(camino!=null){
                if(camino.aristas.contains(arista)){
                    continue;
                }
                newRuta.aristas.addAll(camino.aristas);
                newRuta.PesoCam += camino.PesoCam;
            }
            if(analyzedPaths.get(orig.nombre +from ) != null && analyzedPaths.get(orig.nombre +from )  < newRuta.PesoCam){
                continue;
            }
            analyzedPaths.put(orig.nombre +from , newRuta.PesoCam);
            newRuta.aristas.add(arista);
            newRuta.PesoCam += arista.peso;
            if(arista.segundoVertice.nombre.equals(dest.nombre)){
                if(ruta == null || ruta.PesoCam > newRuta.PesoCam){
                    ruta = newRuta;
                }
            }
            from=arista.segundoVertice;
            ruta(dest, newRuta);
        }
    }
    
    public int minimo(){
        int aux=99999;
        int v=1;
        for(int j=0;  j<numVertices; j++){
            if(!VertVisit[j] && CostoMin[j]<=aux){
                aux=CostoMin[j];
                v=j;
            }
        }
        
        return v;
    }
}

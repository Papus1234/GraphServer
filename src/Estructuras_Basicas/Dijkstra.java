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
            if (orig.nombre.equals(dest.nombre)){
                ruta.vertices.add(orig);
                return ;
            }
        
            else{
                for(int i=0; i<ruta.aristas.size(); i++){//adhiere vertices de la ruta
                 ruta.vertices.add(i,ruta.aristas.get(i).segundoVertice);
            }          
            return;
        }
        }
        for(Arista arista : from.aristas){
            Camino newRuta = new Camino();//se crea un nuevo camino donde se va a trabajar
            if(camino!=null){//si ya existe un camino
                if(camino.aristas.contains(arista)){//se busca si ya la arista se encuentra en el camino
                    continue;//si es así, cotinua con las demás aristas
                }
                newRuta.aristas.addAll(camino.aristas);//agrega todas las aristas del camino existente
                newRuta.PesoCam += camino.PesoCam;//al peso de el nuevo camino se le suman las del camino existente
            }
            if(analyzedPaths.get(orig.nombre +from ) != null && analyzedPaths.get(orig.nombre +from )  < newRuta.PesoCam){
                continue;//si la ruta guardada no es nula y su peso es menor a la ruta actual continua con la siguiente arista
            }
            analyzedPaths.put(orig.nombre +from , newRuta.PesoCam);//si el peso de la ruta es mayor o no exite ruta, la ruta actual se guardará como la menor
            newRuta.aristas.add(arista);//a la nueva ruta se le agrera la arista actual
            newRuta.PesoCam += arista.peso;//al peso de la ruta, se le suma el peso de la arista
            if(arista.segundoVertice.nombre.equals(dest.nombre)){//si donde se dirige la arista es el destino entra
                if(ruta == null || ruta.PesoCam > newRuta.PesoCam){//si la ruta es nula o el peso es mayor a la ruta actual
                    ruta = newRuta;//la ruta final será igual a la ruta actual
                }
            }
            from=arista.segundoVertice;//el inicio será ahora el destino de la arista
            ruta(dest, newRuta);//se llama recursivamente la función
        }
    }
    
    public int minimo(){//calcula el vertice de menor distancia
        int aux=99999;//representa el infinito
        int v=1;//comienza en el índice 1
        for(int j=0;  j<numVertices; j++){
            if(!VertVisit[j] && CostoMin[j]<=aux){//Si el vertice no ha sido visitado y el costo mínimo a ese vertice es menor a infinito
                aux=CostoMin[j];//el auxiliar será igual a su costo mínimo
                v=j;//el índice mínimo será j
            }
        }
        
        return v;//retorna el índice del mínimo
    }
}

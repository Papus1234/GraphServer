/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Estructuras_Basicas.Arco;
import Estructuras_Basicas.Grafo;
import Estructuras_Basicas.Vertice;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Roberto
 */
public class FrameGrafoVisualizer extends JFrame{
        protected static mxGraph graph = new mxGraph();
	protected static HashMap m = new HashMap();
	private mxGraphComponent graphComponent;
	private JTextField texto;
	private Object cell;
    
        public FrameGrafoVisualizer(){
            super("Graph Vizualizer");
            initGUI();
        }
        private void initGUI() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setPreferredSize(new Dimension(670, 380));
		getContentPane().add(graphComponent);
		this.imprimirGrafo();
		
        setLayout(new FlowLayout(FlowLayout.LEFT));
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
		{
		
			public void mouseReleased(MouseEvent e)
			{
				cell = graphComponent.getCellAt(e.getX(), e.getY());		
			}
		});
	}
        public static HashMap getM() {
		return m;
	}
        

	public static mxGraph getGraph() {
		return graph;
	}
        public void AdicionarGrafo(String nombre,int x,int y){
		this.getGraph().getModel().beginUpdate();
		Object parent = this.getGraph().getDefaultParent(); 
		Object v1 = this.getGraph().insertVertex(parent, null, nombre,x, y, 70, 50);
		this.getM().put(nombre, v1);
		this.getGraph().getModel().endUpdate();
                
	}
        public void AdicionarArco(String grafo1,String grafo2,String peso){
		Object parent = this.getGraph().getDefaultParent();
		Object v1 = this.getM().get(grafo1);
        Object v2 = this.getM().get(grafo2);
        String nome = peso;
        this.getGraph().insertEdge(parent, null, nome, v1, v2);
        
	}
                public void imprimirGrafo(){
                Grafo g=new Grafo(33);
                g.agregarVertice(new Vertice("a"));
                g.agregarVertice(new Vertice("b"));
                g.agregarArco(3,g.vertices[0],g.vertices[1]);
                g.agregarArco(3,g.vertices[1],g.vertices[0]);
                
                for (int i=1;i<=g.darArrayVertices().size();i++){
                    
                    this.AdicionarGrafo(g.darArrayVertices().get(i-1).getNombre(),i*50,(i*50)-(i*20));
                    
                }
                for (int i=0;i<g.obtenerArcos().size();i++){
                    Arco aux=g.obtenerArcos().get(i);
                    this.AdicionarArco(aux.getV1().getNombre(),aux.getV2().getNombre(),aux.getPeso());
                    
                }
             //   List<Vertices>
                
                
        }
        
}

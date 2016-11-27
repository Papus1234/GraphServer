/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Estructuras_Basicas.Arista;
import Estructuras_Basicas.Grafo;
import Estructuras_Basicas.Vertice;
import Objetos.Mensaje;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Roberto
 */
public class FrameGrafoVisualizer extends JFrame{
        protected static mxGraph graph ;
	protected static HashMap m ;
	private mxGraphComponent graphComponent;
	private JTextField texto;
        private JButton btnVerMsj;
	private JButton btn1;
	private JButton btn;
	private Object cell;
        private String CeldaSeleccionada;
        public FrameGrafoVisualizer(Grafo g){
            
            super("Graph Vizualizer");
            graph= new mxGraph();
            m = new HashMap();
            initGUI(g);
        }
        private void initGUI(Grafo g) {
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setPreferredSize(new Dimension(670, 380));
                 btnVerMsj = new JButton("Ver Mensajes");
                getContentPane().add(btnVerMsj);
                btnVerMsj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<Mensaje>msj=g.buscarVerticeV(CeldaSeleccionada).getListMsj();
                        
                        for (int i=0;i<msj.size();i++){
                            System.err.println(msj.get(i).getAutor()+":"+msj.get(i).getMensaje()+" destinatario:"+msj.get(i).getDestinatario());
                        }
                    }
                });
                
                getContentPane().add(graphComponent);
		this.imprimirGrafo(g);
		//graphComponent.setBackground(Color.black);
                graphComponent.setConnectable(false);
                
            //    graphComponent.setEnterStopsCellEditing(true);
                
        setLayout(new FlowLayout(FlowLayout.LEFT));
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
		{
		
			public void mouseReleased(MouseEvent e)
			{
				cell = graphComponent.getCellAt(e.getX(), e.getY());
                                
                                CeldaSeleccionada=graph.getModel().getValue(cell)+"";
                                System.err.println(CeldaSeleccionada);
                                //graph.selectVertices(cell);
                          //      graph.
                                
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
                public void imprimirGrafo(Grafo g){
              
               // g.agregarArco(3,g.vertices[1],g.vertices[0]);
                
                for (int i=1;i<=g.darArrayVertices().size();i++){
                     int EspacioRand = (int) (Math.random()*50+1);
                     int EspacioRand2 = (int) (Math.random()*50+1);
                    this.AdicionarGrafo(g.darArrayVertices().get(i-1).getNombre(),i*50+EspacioRand,(i*50)-(i*20)+EspacioRand2);
                    
                }
                for (int i=0;i<g.obtenerArcos().size();i++){
                    Arista aux=g.obtenerArcos().get(i);
                    String aux2=aux.getPeso()+"";
                   // System.out.println(aux.getPeso()+"   nomb:"+aux.getV1().getNombre());
                    this.AdicionarArco(aux.getV1().getNombre(),aux.getV2().getNombre(),aux2);
                    
                }
             //   List<Vertices>
                
                
        }

    
        
}

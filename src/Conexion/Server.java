/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Estructuras_Basicas.BTree.BTree;
import Estructuras_Basicas.Grafo;
import Objetos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Roberto
 */
    
/////////////////Clases del servidor //// para manejar todo mas sencillo 
    public class Server implements Runnable{
    ArrayList clientOutputStreams;
    Grafo grafo;
    BTree ArbB;
    //LIstas ///
    //ArrayList<Usuario>Usuarios;
    ArrayList<String> users;
    ////  Listas fin ///
    JTextArea jtxt;
    public int Port=4444;
    public Server(JTextArea jtex,ArrayList<String>users,Grafo g,BTree Arb){
    this.ArbB=Arb;    
    this.grafo=g;
    clientOutputStreams=new ArrayList();
    this.jtxt=jtex;
    this.users=users;
    
    }
    
    @Override
    public void run(){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Port);
           // String ip=Inet4Address.getLocalHost().getHostAddress();
            //System.out.println(ip);
            
        System.out.println("Servidor Listo ..");
        while(true){
            Socket socket=serverSocket.accept();
            PrintWriter writer=new PrintWriter(socket.getOutputStream());
            clientOutputStreams.add(writer);
           // Thread listener = new Thread(new ClientHandler(clientSock, writer,users,clientOutputStreams));
		//	listener.start();
                
            Thread listener=new Thread(new ServerThread(socket, jtxt, users, clientOutputStreams,grafo,ArbB));
            listener.start();
		
        }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
    
    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

}
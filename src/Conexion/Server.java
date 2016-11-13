/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto
 */
public class Server implements Runnable{
    ArrayList clientOutputStreams;
    public int Port=4444;
    public Server(){
    clientOutputStreams=new ArrayList();
    }
    
    @Override
    public void run(){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Port);
        
        System.out.println("Servidor Listo ..");
        while(true){
            Socket socket=serverSocket.accept();
            PrintWriter writer=new PrintWriter(socket.getOutputStream());
            clientOutputStreams.add(writer);
           // Thread listener = new Thread(new ClientHandler(clientSock, writer,users,clientOutputStreams));
		//	listener.start();
                
            Thread listener=new Thread(new ServerThread(socket,clientOutputStreams));
            listener.start();
		
        }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

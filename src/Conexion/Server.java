/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Roberto
 */
public class Server {
    public int Port=4444;
    public Server(){
    
    }
    public void runServer()throws IOException{
        ServerSocket serverSocket=new ServerSocket(Port);
        System.out.println("Servidor Listo ..");
        while(1){
        Socket socket=serverSocket.accept();
        new ServerThread(socket).start();
        }
    }
    
}

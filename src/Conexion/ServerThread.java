/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Roberto
 */
public class ServerThread extends Thread{
    Socket socket;
    public ServerThread(Socket socket){
        this.socket=socket;
        
        }
    @Override
    public void run(){
        try{
         System.out.println("Pasa por aqui");
        BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String message=bufferedReader.readLine();
            System.out.println(message);
        while ((message=bufferedReader.readLine())!=null){
            System.out.println("Llego mensaje"+message);
            
        }
        //socket.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}

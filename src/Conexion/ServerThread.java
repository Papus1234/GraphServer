/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Roberto
 */
public class ServerThread implements Runnable{
    Socket socket;
    ArrayList clientOutputStreams;
    ArrayList<String> users;
    public ServerThread(Socket socket,ArrayList clientO){
        this.socket=socket;
        this.clientOutputStreams=clientO;
        this.users=users;
        users=new ArrayList<>();
        }
    @Override
    public void run(){
        String message,connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            
        String []data;
        try{
         System.out.println("Pasa por aqui");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((message=bufferedReader.readLine())!=null){
            System.out.println(message);
            data=message.split(":");
            System.out.println(data[0]+"   "+data[2]);
            if (data[2].equals(connect)){
                userAdd(data[0]);
                System.out.println(users.get(0));
            }
            if (data[2].equals(chat)){
                
            }
            System.out.println("Llego mensaje de "+data[0]+"si esta conectado"+data[2]);
            
        }
        //socket.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
     public void userAdd(String data) {
        String message, add = ": :Connect", 
                done = "Server: :Done", 
                name = data;
         System.out.println("Before " + name + " added. \n");
            users.add(name);
        System.out.println("After " + name + " added. \n");
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
     public void tellEveryone(String message){
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		System.out.println("Sending: " + message + "\n");
                writer.flush();
             
            } 
            catch (Exception ex) 
            {
		System.out.println("Error telling everyone. \n");
            }
        } 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Estructuras_Basicas.Grafo;
import Estructuras_Basicas.Vertice;
import Objetos.Mensaje;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Roberto
 */
   public class ServerThread implements Runnable{
    Socket socket;
       JTextArea jTextArea1;
       List<String>users;
       ArrayList clientOutputStreams;
       Grafo g;
    public ServerThread(Socket socket,JTextArea a,List<String>Users,ArrayList clientOutputStreams,Grafo g){
        this.clientOutputStreams=clientOutputStreams;
        this.users=Users;
        this.socket=socket;
        this.jTextArea1=a;
        this.g=g;
        }
    @Override
    public void run(){
        String message,connect = "Connect", 
                disconnect = "Disconnect", 
                chat = "Chat" ;
            
        String []data;
        try{
         System.out.println("Pasa por aqui");
        BufferedReader bufferedReader=new BufferedReader
        (new InputStreamReader(socket.getInputStream()));
        
        while ((message=bufferedReader.readLine())!=null){
              jTextArea1.append("Received: " + message + "\n");
             //tellEveryone("Rober"+":"+"Hola Aaron");      
            System.out.println(message);
            data=message.split(":");
            System.out.println(data[0]+"   "+data[2]);
            
            if (data[2].equals(connect)){
                //Inserta en el grafo 
                this.g.agregarVertice(new Vertice(data[0]));
                this.g.hacerArcosRandom(data[0]);
                
                //
                userAdd(data[0]);
                tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                System.out.println(users.get(0));
            }
            if (data[2].equals(chat)){
                String[]aux=data[1].split("/");
                jTextArea1.append(data[0]+":"+data[1]+"\n");
                System.err.println("Esto es lo que va en mensaje"+message+"   "+aux[0]);
                if (aux.length>1){
                    System.err.println("Esto mensaje:"+data[0] + ":" + aux[0]+aux[1]+ ":" + chat);
                Date date =new Date();
                
                g.buscarVerticeV(data[0]).getListMsj().add(new Mensaje(data[0], aux[0], aux[1],new Date(date.getTime())));
                
                tellEveryone((data[0] + ":" + aux[0]+ ":" + chat),aux[1],data[0]);
                }
                else{
                tellEveryone((data[0] + ":" + data[1]+ ":" + chat));
                    
                }
            }
            System.out.println("Llego mensaje de "+data[0]+"si esta conectado"+data[2]);
            
        }
        //socket.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public void tellEveryone(String message,String destinatario,String name){
	Iterator it = clientOutputStreams.iterator();
        int contador=0;
        while (it.hasNext()) 
        {
            
            try 
            {
            PrintWriter writer = (PrintWriter) it.next();
            if (users.get(contador).equals(name)||users.get(contador).equals(destinatario)){    
                
                
		writer.println(message);
		System.out.println("Sending: " + message + "\n");
                writer.flush();
            
                }
            }
            catch (Exception ex) 
            {
		System.out.println("Error telling everyone. \n");
            }
            
            contador++;
        } 
    }
    /*
    Es un observer que manda el mensaje a todos los usuarios
    @param  String message.
    
    */
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
            System.err.println(message);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
 }
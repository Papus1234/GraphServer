/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Conexion.Server;
import Estructuras_Basicas.Grafo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Roberto
 */
public class FrameServer extends javax.swing.JFrame {
    ArrayList clientOutputStreams;
    ArrayList<String> users=new ArrayList<>();
    Server server;
    Grafo grafo=new Grafo(33);
    /**
     * Creates new form FrameServer
     */
    public FrameServer() {
        initComponents();
        this.jComboBox1.addItem("Seleccione Usuario");
    }
/////////////////Clases del servidor //// para manejar todo mas sencillo 
//    public class Server implements Runnable{
//    public int Port=4444;
//    public Server(){
//    clientOutputStreams=new ArrayList();
//    }
//    
//    @Override
//    public void run(){
//        ServerSocket serverSocket;
//        try {
//            serverSocket = new ServerSocket(Port);
//        
//        System.out.println("Servidor Listo ..");
//        while(true){
//            Socket socket=serverSocket.accept();
//            PrintWriter writer=new PrintWriter(socket.getOutputStream());
//            clientOutputStreams.add(writer);
//           // Thread listener = new Thread(new ClientHandler(clientSock, writer,users,clientOutputStreams));
//		//	listener.start();
//                
//            Thread listener=new Thread(new ServerThread(socket));
//            listener.start();
//		
//        }
//        } catch (IOException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//}
//    
//    
//    
////////////////////77Aca termina server///////////////7   
//    
//    
//////Clase del ServerThread //////////////////    
//    public class ServerThread implements Runnable{
//    Socket socket;
//    public ServerThread(Socket socket){
//        this.socket=socket;
//        }
//    @Override
//    public void run(){
//        String message,connect = "Connect", 
//                disconnect = "Disconnect", 
//                chat = "Chat" ;
//            
//        String []data;
//        try{
//         System.out.println("Pasa por aqui");
//        BufferedReader bufferedReader=new BufferedReader
//        (new InputStreamReader(socket.getInputStream()));
//        
//        while ((message=bufferedReader.readLine())!=null){
//              jTextArea1.append("Received: " + message + "\n");
//                  
//            System.out.println(message);
//            data=message.split(":");
//            System.out.println(data[0]+"   "+data[2]);
//            if (data[2].equals(connect)){
//                
//                userAdd(data[0]);
//                tellEveryone((data[0] + ":" + data[1] + ":" + chat));
//                System.out.println(users.get(0));
//            }
//            if (data[2].equals(chat)){
//                String[]aux=data[1].split("/");
//                jTextArea1.append(data[0]+":"+data[1]+"\n");
//                System.err.println("Esto es lo que va en mensaje"+message+"   "+aux[0]);
//                if (aux.length>1){
//                    System.err.println("Esto mensaje:"+data[0] + ":" + aux[0]+aux[1]+ ":" + chat);
//                
//                tellEveryone((data[0] + ":" + aux[0]+ ":" + chat),aux[1],data[0]);
//                }
//                else{
//                tellEveryone((data[0] + ":" + data[1]+ ":" + chat));
//                    
//                }
//            }
//            System.out.println("Llego mensaje de "+data[0]+"si esta conectado"+data[2]);
//            
//        }
//        //socket.close();
//        
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }    
//    /*
//    Este metodo se usa el patron de observer se le manda un mensaje a todos los usuarios
//    
//    */
//   // Este codigo de observer fue sacado de esta pagina  http://stackoverflow.com/questions/23905719/using-iterator-inside-a-method-with-arraylist
//    public void tellEveryone(String message,String destinatario,String name){
//	Iterator it = clientOutputStreams.iterator();
//        int contador=0;
//        while (it.hasNext()) 
//        {
//            
//            try 
//            {
//            PrintWriter writer = (PrintWriter) it.next();
//            if (users.get(contador).equals(name)||users.get(contador).equals(destinatario)){    
//                
//                
//		writer.println(message);
//		System.out.println("Sending: " + message + "\n");
//                writer.flush();
//            
//                }
//            }
//            catch (Exception ex) 
//            {
//		System.out.println("Error telling everyone. \n");
//            }
//            
//            contador++;
//        } 
//    }
//    /*
//    Es un observer que manda el mensaje a todos los usuarios
//    @param  String message.
//    
//    */
//    public void tellEveryone(String message){
//	Iterator it = clientOutputStreams.iterator();
//     
//        while (it.hasNext()) 
//        {
//            
//            try 
//            {
//                PrintWriter writer = (PrintWriter) it.next();
//                
//		writer.println(message);
//		System.out.println("Sending: " + message + "\n");
//                writer.flush();
//             
//            } 
//            catch (Exception ex) 
//            {
//		System.out.println("Error telling everyone. \n");
//            }
//        } 
//    }
//    public void userAdd(String data) {
//        String message, add = ": :Connect", 
//                done = "Server: :Done", 
//                name = data;
//         System.out.println("Before " + name + " added. \n");
//            users.add(name);
//        System.out.println("After " + name + " added. \n");
//        String[] tempList = new String[(users.size())];
//        users.toArray(tempList);
//
//        for (String token:tempList) 
//        {
//            message = (token + add);
//            System.err.println(message);
//            tellEveryone(message);
//        }
//        tellEveryone(done);
//    }
//    
//}

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        MostrarUsuarios = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        BGrafo = new javax.swing.JButton();
        BArbol = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MostrarUsuarios.setText("Mostrar Usuarios");
        MostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarUsuariosActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        BGrafo.setText("MostrarGrafo");
        BGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGrafoActionPerformed(evt);
            }
        });

        BArbol.setText("Mostrar Arbol B");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(MostrarUsuarios)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(BGrafo)
                .addGap(35, 35, 35)
                .addComponent(BArbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Clear)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(MostrarUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear)
                    .addComponent(BArbol)
                    .addComponent(BGrafo))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       

// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      

// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        server=new Server(jTextArea1,users,grafo); 
        Thread starter = new Thread(server);
        starter.start();
        this.jTextArea1.append("Server Iniciado...\n");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarUsuariosActionPerformed
        String []a=new String[users.size()];
       // System.out.println("este es un item :"+a[0]);
        
         DefaultComboBoxModel model = new DefaultComboBoxModel(users.toArray(a));
         jComboBox1.setModel(model);


        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarUsuariosActionPerformed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        String []a=new String[users.size()];
       // System.out.println("este es un item :"+a[0]);
        
         DefaultComboBoxModel model = new DefaultComboBoxModel(users.toArray(a));
         jComboBox1.setModel(model);
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1FocusGained

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        jTextArea1.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_ClearActionPerformed

    private void BGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGrafoActionPerformed
        FrameGrafoVisualizer VisGrafo=new FrameGrafoVisualizer(grafo);
            VisGrafo.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BGrafoActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameServer().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BArbol;
    private javax.swing.JButton BGrafo;
    private javax.swing.JButton Clear;
    private javax.swing.JButton MostrarUsuarios;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

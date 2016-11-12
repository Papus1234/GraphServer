/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphserver;

import Conexion.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto
 */
public class GraphServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Server().runServer();
            
            // TODO code application logic here
        } catch (IOException ex) {
            Logger.getLogger(GraphServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

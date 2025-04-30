/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ftpserver;

/**
 *
 * @author francesco.roccabruna
 */
import java.io.IOException;
import java.net.*;

public class FTPServer {

    private final int SERVER_PORT = 2000;
    public static void main(String[] args) {
        FTPServer srv = new FTPServer();
        
        try{
            srv.listen();
        
        }catch(Exception a){
            System.out.println(a);
        }
    }   
    
    private void listen()throws IOException{
        ServerSocket sSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server in ascolto sulla porta locale 2000");
        for (;;){
            Socket connection = sSocket.accept();
            new ReceiverManager(connection).run();
            
            try {
                Thread.sleep(100);
            }catch(InterruptedException a){
                System.out.println(a);
            }
        }
        
    }
}

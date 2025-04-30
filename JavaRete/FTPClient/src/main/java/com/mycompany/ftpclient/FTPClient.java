/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ftpclient;

/**
 *
 * @author francesco.roccabruna
 */
import java.io.File;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FTPClient {

    private final String SERVER_HOST = "127.0.0.1";
    private final int SERVER_PORT = 2000;
    
    public static void main(String[] args) {
        
        String path;
        FTPClient clt = new FTPClient();
        try{
            File file;
            //inseriamo da tastiera il percorso del file
            // es c:/Lavoro-temp/prova.txt
            
            System.out.println("Inserire il percorso (es c:/Lavoro-temp/prova.txt))");
            Scanner scanString = new Scanner(System.in);
            path = "";
            try{
                path = scanString.nextLine();
                scanString.close();
            }catch(InputMismatchException a){
                System.err.println(a);
            }
            file = new File(path);
            clt.sendFile(file);
            
        }catch(Exception a){
            a.printStackTrace();
        }
    }
    
    public void sendFile(File file) throws IOException{
        Socket socket = null;
        try{
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            
        }catch(UnknownHostException a){
            a.printStackTrace();
        }
        
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.reset();
        outputStream.writeObject(file);
        outputStream.flush();
        outputStream.close();
        
    }
}

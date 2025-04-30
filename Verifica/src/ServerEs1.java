import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.xml.crypto.Data;

public class ServerEs1 {
    private DatagramSocket socket;
    private int port;
    private DatagramPacket inPacket;
    private DatagramPacket outPacket;

    public ServerEs1(){
        port = 1234;
    }

    public static void main(String[] args) throws Exception {
        ServerEs1 server = new ServerEs1();
        server.start();
    }


    public void start(){
        try{
            socket = new DatagramSocket(port);
            try{
                while (true){
                    byte[] data = new byte[256];
                    inPacket = new DatagramPacket(data, data.length);
                    socket.receive(inPacket);

                    InetAddress addressC = inPacket.getAddress();
                    int portC = inPacket.getPort();
                    System.out.println(inPacket.getData()[0]);
                    String messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
                    //Double temp = messageIn.
                    //System.out.println(messageIn);
                    Double temp = Double.parseDouble(messageIn);
                    double calcolo = temp*1.8 +32;
                    String messageOut = String.valueOf(calcolo);
                    outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), addressC, portC);
                    socket.send(outPacket);
                    
                }
                
            }catch(IOException a){
                System.err.println(a);
            }
            


        }catch(SocketException a){
            System.err.println(a);
        }
        
    }
}

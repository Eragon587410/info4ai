import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.spec.ECFieldF2m;
import java.util.Scanner;

public class ClientEs2 {
    private DatagramSocket socket;
    private int port;
    private DatagramPacket inPacket;
    private DatagramPacket outPacket;
    private InetAddress address;

    public ClientEs2(){
        port = 1234;
    }

    public void start(){
        try{
            while(true){
                socket = new DatagramSocket();
            
                String input = new Scanner(System.in).nextLine();
                
                String messageOut = input;
                address = InetAddress.getLocalHost();
                //System.out.println(messageOut);
                outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), address, port);
                socket.send(outPacket);
            
                byte[] buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(inPacket);
                String messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("Valore operazione: " + messageIn);
                
                
            }


        }catch(Exception a){}
    }

    public static void main(String[] args) throws Exception{
        ClientEs2 client = new ClientEs2();
        client.start();
    }
}









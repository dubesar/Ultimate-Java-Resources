// This is a java program to display the use of the java.net.Socket class

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// import java server socket
import java.net.ServerSocket;
// import java client socket
import java.net.Socket;

/**
* Example using sockets Client/Server 
*/
public class SocketExample {
	
    public static void main(String[] args) {
        SocketServerExample server = new SocketServerExample(); // Aways need new intance to use in static context
        SocketClientExample client = new SocketClientExample(); // Aways need new instance to use in static context
        
        // Run server in a new Thread.
        new Thread(() -> server.startServer(9191)).start(); // Lambda expression to instantiate new Thread
        // Run cliente 
        client.runClient("127.0.0.1", 9191);
    }
}

/**
 * SocketServer example class
 * This example consists in one Socket Server to be a road of data
 * and two Socket Clients, one for send data between socket server and other to recive this data.
 */
class SocketServerExample {
	
        public void startServer(int port) { // method startServer recive int port value
        try {
            //Start the server in informed port and wait for connection to initiate
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server Started. Waiting for connection ...");
            
            // Accept new cliente connection 
            Socket socket = server.accept();
            System.out.println("Got connection from client.");
            
            //Get input stream from socket variable and convert the same to DataInputStream
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            //Read type and length of data transmited
            char dataType = in.readChar();
            int length = in.readInt();
            
            System.out.println("Type : "+ dataType);
            System.out.println("Lenght :"+ length);
            
            if(dataType == 's') { // 's' is a String
                //Read String data in bytes
                byte[] messageByte = new byte[length];
                boolean end = false;
                StringBuilder dataString = new StringBuilder(length); // Initiate StringBuild with pre aloccated size of length
                int totalBytesRead = 0;
            
                //We need to run while loop, to read all data in that stream
                while(!end) {
                    // read byte
                    int currentBytesRead = in.read(messageByte);
                    // Add add to counter
                    totalBytesRead = currentBytesRead + totalBytesRead;
                    
                    if(totalBytesRead <= length) { // have more bytes in message?
                        // yes add final byte
                        dataString.append(new String(messageByte,0,currentBytesRead,StandardCharsets.UTF_8));
                    } else {
                        // no, add byte to dataString
                        dataString.append(new String(messageByte,0,length - totalBytesRead + currentBytesRead,StandardCharsets.UTF_8));
                    }
                    // Verify end of messsage.
                    if(dataString.length()>=length) {
                        end = true;
                    }
                }
                // Show content of bytes recieved
                System.out.println("Read "+length+" bytes of message from client. Message = "+dataString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Client Socket class to sending data in TLV format.
 */
class SocketClientExample {
	
    public void runClient(String ip, int port) {
        try {
            // New Socket client
            Socket socket = new Socket(ip, port);
            System.out.println("Connected to server ...");
            
            // Instance of DataStream in/out
            DataInputStream in = new DataInputStream(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            char type = 's'; // s for string
            String data = "This is a string of length 29";
            int length = data.length(); // length of pack to send
            
            // Convert String to bytes to transmit
            // Charset is importante to reciver
            byte[] dataInBytes = data.getBytes(StandardCharsets.UTF_8);
            
            //Sending data in TLV format  
            //TLV (type-length-value) is an encoding scheme used for optional information element in a certain protocol.
            out.writeChar(type);
            out.writeInt(length);
            out.write(dataInBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import java.net.UnknownHostException;
import java.io.IOException;

public class ServerConnect {

	/** G01111581
	 * @author Alex Lawson
	 * 
	 * my knock, knock joke connection application
	 * Connecting several times to the server and completed the knock, knock joke protocol
	 */
   
    public static void main(String[] args) {
       
        Socket clientSocket = null; 
        DataOutputStream os = null;
        BufferedReader is = null;
        BufferedReader inFromUser = null;
       
        try {
            //set up an outgoing connection
            clientSocket = new Socket("ec2-34-218-41-170.us-west-2.compute.amazonaws.com", 8989);
           
            //get ready to send the client message
            os = new DataOutputStream(clientSocket.getOutputStream());
           
            //get ready to read the server's response
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           
            //get ready to ready data from user
            inFromUser = new BufferedReader(new InputStreamReader(System.in));
           
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
 
    if (clientSocket != null && os != null && is != null) {
            try {
 
                System.out.println(is.readLine() );
               
                String msgToServer = inFromUser.readLine();
               
                do {
                    os.writeBytes(msgToServer + "\n");
                    System.out.println(is.readLine() );
                    msgToServer = inFromUser.readLine();
               
                }while (msgToServer.compareTo("exit") != 0); //continue interacting with server while
                												//user doesn't enter "exit"
               
                os.close();
                is.close();
                inFromUser.close();
                 
            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
   
    }
}
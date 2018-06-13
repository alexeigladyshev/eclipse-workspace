/**
 * 
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author john.mcdowall3
 * Code adapted and extended from code in Computer Networking: A Top Down Approach
 * by Kurose and Ross
 */
public class TCPServer {

	/**
	 * @param args
	 */
	private static String inputFromClient;
	private static String outputToClient;
	
	public static void main(String[] args) {
		//Set up a server and start listening for clients		
		try{
			//Set up a server socket
			ServerSocket serverSocket = new ServerSocket(8989);
			System.out.println("TCP Server is up and running");
			
			//Create a socket to accept incoming connections 
			Socket clientSocket = serverSocket.accept();
			
			//Handle incoming connections
			while(true){
				
				//Create an input stream to read what the client sends
				BufferedReader textFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				//Create an output stream to send a reply
				DataOutputStream textToClient = new DataOutputStream(clientSocket.getOutputStream());
				//Read the input from the incoming connection
				inputFromClient = textFromClient.readLine();
				System.out.println("Text from client: " + inputFromClient);
				//Decide if this is a shutdown command
				if(inputFromClient.equalsIgnoreCase("Shutdown")){
					System.out.println("Server shutting down");
					serverSocket.close();
					System.exit(1);
				}
				//Prepare the reply
				outputToClient = reverseString(inputFromClient) + "\n";
				//Send the reply
				textToClient.writeBytes(outputToClient);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static String reverseString(String s){
		//Take the input string, reverse it, and return it
		String outputString = "";
		char[] inputString = s.toCharArray();
		for(int i = inputString.length - 1; i >= 0; i--){
			outputString = outputString + inputString[i];
		}
		
		return outputString;
	}

}

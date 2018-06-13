import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class kkTCPServer {

	/**
	 * @author alex lawson
	 * code adapted from Professor McDowall's and book Computer Networking: A Top-Down Approach
	 */
	
	private static String inputFromClient;
	private static String outputToClient;
	
	private static boolean knockknock=false, jokesetup=false;
	
	public static void main(String[] args) {
		//Set up a server and start listening for clients		
		try{
			//Set up a server socket
			ServerSocket serverSocket = new ServerSocket(8980);
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
				//System.out.println("Text from client: " + inputFromClient);
				
				//Decide if this is a shutdown command
				if(inputFromClient.equalsIgnoreCase("Shutdown")){
					System.out.println("Server shutting down");
					serverSocket.close();
					System.exit(1);
				}				
				
				
				//knock-knock joke process
				if (knockknock == false && jokesetup == false) {
					if (inputFromClient.equalsIgnoreCase("knock, knock")) {
						knockknock = true;
						outputToClient = "Who's there?\n";
					}
					else {
						outputToClient = "Improper joke initation. Please initiate with 'Knock, knock'\n";
					}
				}
				else if (knockknock == true && jokesetup == false) {
					jokesetup = true;
					outputToClient = inputFromClient + " who?\n";
				}
				else if (knockknock == true && jokesetup == true) {
					knockknock = false;
					jokesetup = false;
					outputToClient = "Hahahaha! That was a good one.\n";
				}
				else {
					outputToClient = "Improper joke initation. Please initiate with 'Knock, knock'\n";
				}
				
				//Send the reply
				textToClient.writeBytes(outputToClient);
			}
		}
		catch(Exception e){
			//print the stack trace in case of an error
			e.printStackTrace();
		}

	}
	
}

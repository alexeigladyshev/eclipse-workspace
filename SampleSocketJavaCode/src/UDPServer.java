/**
 * 
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author john.mcdowall3
 * Code adapted and extended from code in Computer Networking: A Top Down Approach
 * by Kurose and Ross
 */
public class UDPServer {

	/**
	 * @param args
	 */
	
	private static String inputFromClient;
	private static String outputToClient;
	
	public static void main(String[] args) {
		//Set up a server and start listening for clients
		try {
			//Create the socket
			DatagramSocket serverSocket = new DatagramSocket(1989);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			
			System.out.println("UDP Server is up and running");
			
			while(true){
				//A packet to catch the received data
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				
				//Turn the received data into a string
				inputFromClient = new String(receivePacket.getData()).trim();
				System.out.println("Text from client: " + inputFromClient);
				
				//Check for a shutdown message
				if(inputFromClient.equalsIgnoreCase("Shutdown")){
					System.out.println("Server shutting down");
					serverSocket.close();
					System.exit(1);
				}
				
				//Get the address and port the packet came from
				InetAddress ipAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				
				//Convert the string the client sent
				outputToClient = reverseString(inputFromClient);
				
				//Send the response
				sendData = outputToClient.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
				serverSocket.send(sendPacket);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

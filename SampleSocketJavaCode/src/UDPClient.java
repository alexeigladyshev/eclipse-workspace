/**
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author john.mcdowall3
 * Code adapted and extended from code in Computer Networking: A Top Down Approach
 * by Kurose and Ross
 */
public class UDPClient {

	/**
	 * @param args
	 */
	
	private static String textFromUser;
	private static String responseFromServer;
	private static Boolean running = true;
	
	public static void main(String[] args) {
		//Get ready to read input from the user
		try {
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			//Create a socket to connect to the server
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress ipAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			
			System.out.println("Client is up and running");
			
			while (running == true) {
				//Read in data from the user
				textFromUser = inFromUser.readLine();
				sendData = textFromUser.getBytes();
				//Prepare an send the packet
				DatagramPacket outgoingPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 1989);
				clientSocket.send(outgoingPacket);
				if(textFromUser.equalsIgnoreCase("Shutdown")){
					running = false;
				}
				else{
					//Get a response
					DatagramPacket incomingPacket = new DatagramPacket(receiveData, receiveData.length);
					clientSocket.receive(incomingPacket);
					responseFromServer = new String(incomingPacket.getData());
					System.out.println("Server response: " + responseFromServer);
				}
			}
			clientSocket.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

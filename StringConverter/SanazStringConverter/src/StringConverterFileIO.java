//package assinment8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.*;

/**
 * @author Zahra Rajabi
 * example instruction to run: 
 * java StringConverterFileIO.java input.txt output.txt
 */
public class StringConverterFileIO {
	
	public static boolean validatePhone(String phone) { // (xxx)xxx-xxxx
		// example: (WOa)2T2-22dR --> (962)282-2237
		String regex = "\\([1-9[a-zA-Z]][0-9[a-zA-Z]]{2}\\)[0-9[a-zA-Z]]{3}-[0-9[a-zA-Z]]{4}"; // used pattern union: [a-d[m-p]]	a through d, or m through p: [a-dm-p] 
		return phone.matches(regex);
	}
	
	public static String convertPhone(String phone) {
		
		phone = phone.replaceAll("[abcABC]", "2");
		phone = phone.replaceAll("[defDEF]", "3");
		phone = phone.replaceAll("[ghiGHI]", "4");
		phone = phone.replaceAll("[jklJKL]", "5");
		phone = phone.replaceAll("[mnoMNO]", "6");
		phone = phone.replaceAll("[pqrsPQRS]", "7");
		phone = phone.replaceAll("[tuvTUV]", "8");
		phone = phone.replaceAll("[wxyzWXYZ]", "9");
		
		return phone;
	}
	
	/**
	 * @param ssn
	 * @return True if social security number is in the form of xxx-xx-xxxx, where x is a digit
	 */
	public static boolean validateSocialSecurity(String ssn) {
		String regex = "\\d{3}-\\d{2}-\\d{4}";
		return ssn.matches(regex);
	}
	
	/**
	 * @param loginId
	 * @return True if the input login id is digits, alphabet letters, or the special characters of !@#$%^&*.
	 */
	public static boolean validateLoginId(String loginId) {
		String regex = "([0-9]|[a-zA-Z]|[!@#$%^&*])*";
		return loginId.matches(regex);
	}
	
	/**
	 * @param loginId
	 * @return loginId after removing special characters
	 */
	public static String convertLoginId(String loginId) {
		String regex = "[!@#$%^&*]";
		loginId = loginId.replaceAll(regex, "");
		return loginId;
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.printf("Error, Please re-enter the entire command");
		}
		else
		{
			
			String filePath = "C:\\Users\\Sanaz.raj\\eclipse-workspace\\assignments\\src\\assinment8\\";
			
			//read the input file name and output file name from the command line arguments
			String inputFilename = args[0];
			String outputFilename = args[1];
			//outputFilename = "output.txt";
			
		    //Scanner sc = new Scanner(new File(filePath+"input.txt"));
			Scanner sc = new Scanner(new File(inputFilename));
		    
		    String inStr = "";
		    String outStr = "";
		    
		    try(Formatter output = new Formatter(outputFilename)){
		    	while (sc.hasNext()) { 
		    		String s = sc.nextLine(); // reads a line from input file
		  	      	if (s.trim().isEmpty()) { //trims extra leading or trailing white spaces
		  	      		continue;
		  	      	}
		  	      	
		  	       
		  	      	String str1 = "phone number:";
		  	      	String str2 = "social security number:";
		  	      	String str3 = "login id:";
		  	      	s = s.toLowerCase();
	
		  	      	if (s.startsWith("phone")) {
		  	      		String phone = s.replace(str1, "").trim(); // removes "phone number:" and any white spaces 
		  	    	  
		  	      		if (validatePhone(phone)) {
		  	      			phone = convertPhone(phone);
		  					System.out.println(phone);
		  					outStr = phone;
		  					inStr = str1;
		  	      		}
		  	      	}
		  	      
		  	      	if (s.startsWith("social")) {
		  	      		String ssn = s.replace(str2, "").trim();
		  	      		if (validateSocialSecurity(ssn)) {
		  	      			ssn = ssn.replace(ssn.substring(0, 6),"xxx-xx");
		  	      			System.out.println(ssn);
		  	      			outStr = ssn;
		  	      			inStr = str2;	
		  	      		}
		  	      	}
		  	      
		  	      	if (s.startsWith("login")) {
		  	      		String loginId = s.replace(str3, "").trim();
		  	      		if (validateLoginId(loginId)) { 
		  	      			loginId = convertLoginId(loginId);
		  	      			if (loginId.length() > 8) { //If the length of the user id after removing the special characters is greater than eight, 
		  						loginId = loginId.substring(0, 8); //truncate the remaining characters.
		  					}
		  					
		  					if (loginId.length() == 0) {
		  						System.out.println("ERROR: The login ID is not valid!\n");
		  					}
		  					else {
		  						System.out.println(loginId);
		  					}
		  					outStr = loginId;
		  					inStr = str3;
		  				}
		  	      	}
		  	      	
		  	      	try { //write on file
		    			output.format("%s %s %n",inStr,outStr);
		    		}
		    		catch (NoSuchElementException e2) {
		    			System.err.println("Cannot write on output file");
		    		}
		  	      
		  	      	
		  	      	
		    	}// end of while
		    }
		    catch(SecurityException | FileNotFoundException | FormatterClosedException e) {
		    	e.printStackTrace();
		    }
		    
		    
		    sc.useDelimiter(" ");
		    while (sc.hasNext()) {
		    	
		    	
		      String s = sc.nextLine(); // reads a line
		      if (s.trim().isEmpty()) {
		        continue;
		      }
		       
		      String str1 = "phone number:";
		      String str2 = "social security number:";
		      String str3 = "login id:";
		      s = s.toLowerCase();
	
		      if (s.startsWith("phone")) {
		    	  String phone = s.replace(str1, "").trim(); // removes "phone number:" and any white spaces 
		    	  
		    	  if (validatePhone(phone)) {
						phone = convertPhone(phone);
						System.out.println(phone);
						
				}
		      }
		      
		      if (s.startsWith("social")) {
		    	  String ssn = s.replace(str2, "").trim();
		    	  if (validateSocialSecurity(ssn)) {
		    		  ssn = ssn.replace(ssn.substring(0, 6),"xxx-xx");
		    		  System.out.println(ssn);
				 }
		      }
		      
		      if (s.startsWith("login")) {
		    	  String loginId = s.replace(str3, "").trim();
		    	  if (validateLoginId(loginId)) {
						loginId = convertLoginId(loginId);
						if (loginId.length() > 8) { //If the length of the user id after removing the special characters is greater than eight, 
							loginId = loginId.substring(0, 8); //truncate the remaining characters.
						}
						
						if (loginId.length() == 0) {
							System.out.println("ERROR: The login ID is not valid!\n");
						}
						else {
							System.out.println(loginId);
						}
					}
		      }
		      
		      
		      
		    } // while
		    
		    sc.close();
	  }
	}
}


	


import java.util.Scanner;

/**
 * Assignment #1.1 Fix Me!
 * 
 * Goal: Learn Java syntax and practice good programming practice.
 * 
*/
public class FixMe {   //renamed to FixMe
	
	public static void main(String[] args) //needed word "static" for Java to know this is main class
	{										//parameter passed must be Array of Strings
		
		System.out.println("Please fix me!");
		System.out.println("What is wrong with this code?"); /*this line of code was separated into 2 lines
															and the compiler was throwing an error*/ 
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); //java.util.Scanner package needs to be imported
		System.out.println("Enter first integer: ");
		int number1 = input.nextInt(); //can't have spaces in variable names when declaring variables
		
		System.out.println("Enter second integer: ");
		int number2 = input.nextInt();
		
		if(number1 == number2)    	//when comparing two values, must use doubles equals sign
									//Don't need the semicolon after the if-statement
			System.out.printf("%d is equal to %d\n", number1, number2); //didn't need extra closing parentheses in this line 
														//I added a new line after this line executes
		System.out.println("Congratulations! It's working now!"); //needs a semicolon at end of statement
			
	}
} //needed an extra closing curly brace for the main class
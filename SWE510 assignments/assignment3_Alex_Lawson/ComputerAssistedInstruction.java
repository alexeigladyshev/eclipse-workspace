import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstruction {

	public static void main(String[] args) {
		
		final int RANGE = 9;
		
		SecureRandom randomNumbers = new SecureRandom();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int num1 = 1+randomNumbers.nextInt(RANGE);
		int num2 = 1+randomNumbers.nextInt(RANGE);
		
		int answer = num1*num2;
		int guess;
		int response = 1 + randomNumbers.nextInt(6);
		
		do {
			askQuestion(num1, num2);
			guess = input.nextInt();
			if (guess == answer)
				goodAnswer(response);
			else {
				if (guess != -1)
					badAnswer(response);
			}
			
			num1 = 1+randomNumbers.nextInt(RANGE);
			num2 = 1+randomNumbers.nextInt(RANGE);
			answer = num1*num2;
			response = 1 + randomNumbers.nextInt(6);
			
		}while (guess != -1);
		
		System.out.println("Goodbye!\n");
	}
	
	private static void askQuestion(int num1, int num2) {
		
		System.out.printf("How much is %d times %d? ", num1, num2);
	}
	
	private static void goodAnswer(int option) {
		switch(option) {
			case 1: System.out.println("Very good!"); break;
			case 2: System.out.println("Excellent!"); break;
			case 3: System.out.println("Impressive!"); break;
			case 4: System.out.println("Keep it up!"); break;
			case 5: System.out.println("Way to go!"); break;
			case 6: System.out.println("Yes!"); break;
		}
		
	}
	private static void badAnswer(int option) {
		switch(option) {
			case 1: System.out.println("No. Please try again."); break;
			case 2: System.out.println("I'm sorry. That's incorrect."); break;
			case 3: System.out.println("Try once more."); break;
			case 4: System.out.println("Don't give up."); break;
			case 5: System.out.println("I'm sorry, but that's incorrect."); break;
			case 6: System.out.println("No. Please try a different problem."); break;
	}
	}
	
}
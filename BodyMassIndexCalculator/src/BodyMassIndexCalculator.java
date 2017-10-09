import java.util.Scanner;

public class BodyMassIndexCalculator {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your height (in inches): ");
		int height = input.nextInt();
		System.out.println();
		
		System.out.print("Enter your weight (in pounds): ");
		int weight = input.nextInt();
		System.out.println();
		
		int BMI = weight*703/height/height;
		
		System.out.printf("Your BMI is %d.\n", BMI);
		
		String category;
		
		if (BMI <= 18) category = "underweight";
		else if (BMI > 18 && BMI <=25) category = "normal weight";
		else if (BMI > 25 && BMI <=30) category = "overweight";
		else category = "obese";
		
		System.out.println();
		System.out.printf("You are %s.", category);
		
	}
}

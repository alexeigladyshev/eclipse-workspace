import java.util.Scanner;

public class TemperatureBarChart {

	public static void main(String[] args) {

	
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int[] days = new int[7];
		
		for (int i=0; i<7;i++) {
			System.out.print("Enter the high temperature of day "+(i+1)+": ");
			days[i] = input.nextInt();
		
		}
		System.out.println("\nTemperature bar chart:");
		for (int i =0; i<7;i++) {
			System.out.print("Day "+(i+1)+": ");
			
			for (int j=0; j<days[i];j++) {
				System.out.print("*");
			}
		
			System.out.println();
		}
		System.out.println();
	}
	
}

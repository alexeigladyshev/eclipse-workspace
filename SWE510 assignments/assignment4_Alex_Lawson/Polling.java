import java.util.Scanner;

/**
 * Date: 9/27/2017. This is an application for surveying recreational sports and
 * printing results.
 * 
 * @author Alex Lawson
 * @version 1.0
 * 
 */

public class Polling {

	/**
	 * The main method of this application. I use an enhanced for statement in this
	 * method. You have to enter 1 through 10 for the sports for the program to
	 * work, otherwise will crash by throwing an exception.
	 * 
	 * @param args array of string arguments.
	 * 
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int rating;
		
		//counts how many people were surveyed
		int numOfSurveys=0;

		String[] sports = { "TENNIS", "SWIMMING", "JOGGING", "SOCCER", "BASKETBALL" };

		int[][] responses = new int[5][10];
		String answer = "yes";

		System.out.println("Welcome to the Recreational sports survey!\n");

		//loop and increment our 2-d array until the user stops typing "yes"
		while (answer.equals("yes")) {
			numOfSurveys++;
			
			for (String sport : sports) { // enhanced for statement
				System.out.print("Please rate  (1 to 10) the following recreational sport " + sport + ": ");
				rating = input.nextInt();
				addResult(sport, rating, responses);
			}
			System.out.print("Continue polling? Type 'yes' to continue, anything else to stop: ");
			input.nextLine();
			answer = input.nextLine();
			System.out.println();
		}

		// after we have our 2-d array, we call these 2 methods
		System.out.printf("Number of people surveyed: %d\n", numOfSurveys);
		printResult(responses); // after collecting the survey, print the result
		highLowTotal(responses); // after the matrix, print highest and lowest point total

	}

	/**
	 * This method increments the 2-d array responses based on the sport and result
	 * that is passed.
	 * 
	 * @param sport
	 *            the String that determines which row of results array to increment
	 * @param result
	 *            the value that the user gave for that particular sport
	 * @param responses
	 *            is the 2-d array that gets modified
	 * 
	 */
	private static void addResult(String sport, int result, int[][] responses) {

		switch (sport) {
		case "TENNIS":
			responses[0][result - 1]++;
			break;
		case "SWIMMING":
			responses[1][result - 1]++;
			break;
		case "JOGGING":
			responses[2][result - 1]++;
			break;
		case "SOCCER":
			responses[3][result - 1]++;
			break;
		case "BASKETBALL":
			responses[4][result - 1]++;
			break;
		}

	}

	/**
	 * This method prints and formats the 2-d array to the screen, along with
	 * information on the averages
	 * 
	 * @param responses
	 *            is the 2-d array that is accessed to print the results from every
	 *            row and column
	 */
	private static void printResult(int[][] responses) {

		System.out.println();

		System.out.printf("%-9s", "Ratings");
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%-3d", i);
		}
		System.out.print("\n\n");

		for (int i = 0; i < responses.length; i++) {

			switch (i) {
			case 0:
				System.out.printf("%-9s", "Tennis");
				break;
			case 1:
				System.out.printf("%-9s", "Swimming");
				break;
			case 2:
				System.out.printf("%-9s", "Jogging");
				break;
			case 3:
				System.out.printf("%-9s", "Soccer");
				break;
			case 4:
				System.out.printf("%-9s", "B-ball");
				break;
			}

			for (int j = 0; j < responses[i].length; j++) {

				System.out.printf("%-3d", responses[i][j]);
			}
			calculateAvg(responses[i]);
			System.out.println();
		}

		System.out.println();
	}

	/**
	 * This method is used strictly to print averages at end of ever line. Called
	 * within printResult method as a helper method.
	 * 
	 * @param response
	 *            is the 2-d array that is accessed to extract the desired results.
	 */
	private static void calculateAvg(int[] response) {

		int sum = 0;
		int numberSurveyed = 0;

		for (int val : response) // enhanced for statement
			numberSurveyed += val;

		for (int i = 0; i < response.length; i++) {
			sum += response[i] * (i + 1);
		}
		System.out.printf(" Average rating: %1.1f", sum / (double) numberSurveyed);
	}

	/**
	 * This method prints what sports got the highest and total values, and what
	 * those values are. This is called by the main method after the 2-d array has
	 * been created. This method is the most complicated due to its nature.
	 * 
	 * @param responses
	 *            is the 2-day array that is passed to calculate the highest and
	 *            lowest values and what sports had those values. Everything else is
	 *            done and extracted by the method.
	 */
	private static void highLowTotal(int[][] responses) {

		boolean[] high = new boolean[5];
		boolean[] low = new boolean[5];
		// two arrays of the highest and lowest sport totals (in case we have more than
		// 1 sport that has
		// a maximum or minimum sport, you want to record all of them

		int highest = 0;
		int lowest = 0;
		int counter = 0;

		for (int i = 0; i < responses.length; i++) {

			for (int j = 0; j < responses[i].length; j++) {
				counter += responses[i][j] * (j + 1);

			}
			// make the lowest counter the sum of the first result
			if (i == 0)
				lowest = counter;

			if (counter >= highest) {

				if (counter == highest)
					high[i] = true;
				else {
					high = new boolean[5];
					high[i] = true;
				}
				highest = counter;
			}
			if (counter <= lowest) {

				if (counter < lowest) {
					low = new boolean[5];
					low[i] = true;
				} else {
					low[i] = true;
				}
				lowest = counter;

			}
			counter = 0;
		}

		// now that we have filled our 2 boolean arrays, we print their contents for the
		// user
		System.out.println("\nHighest point total: " + highest);
		for (int i = 0; i < high.length; i++) {

			if (high[i]) {
				switch (i) {
				case 0:
					System.out.println("Tennis");
					break;
				case 1:
					System.out.println("Swimming");
					break;
				case 2:
					System.out.println("Jogging");
					break;
				case 3:
					System.out.println("Soccer");
					break;
				case 4:
					System.out.println("Basketball");
					break;
				}
			}
		}

		System.out.println("\nLowest point total: " + lowest);

		// print the contents of the low values same as the high values
		for (int i = 0; i < low.length; i++) {

			if (low[i]) {

				switch (i) {
				case 0:
					System.out.println("Tennis");
					break;
				case 1:
					System.out.println("Swimming");
					break;
				case 2:
					System.out.println("Jogging");
					break;
				case 3:
					System.out.println("Soccer");
					break;
				case 4:
					System.out.println("Basketball");
					break;
				}
			}
		}
	}

}

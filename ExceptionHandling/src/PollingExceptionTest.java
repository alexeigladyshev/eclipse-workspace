import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Conduct a survey for favorite Winter Olympic sports. This class reads ratings
 * from survey respondents and display the result statistics including average
 * ratings per topic and the highest and lowest rated topics The input
 * validation in this program is intentionally incomplete
 * 
 * Please do not distribute this code outside the class of SWE510 Fall, 2017
 * 
 * @author Yonghee Shin
 *
 */
public class PollingExceptionTest {

	private static final String[] surveyTopics = { "Speed Skating", "Snowboard", "Figure Skating", "Bobsleigh",
			"Ice Hockey" };
	private static final int RATING_SCALE = 10; // Declaring literals as constants improve code readability and
												// maintainability
	private int numRespondents;

	private class TopicTotalRatingPair { // this private inner class is a part of implementation of outter class Polling
											// and not available outside class Polling.
											// Therefore, we don't need to provide public getter methods
		String topic;
		int rating;

		TopicTotalRatingPair(String topic, int rating) {
			this.topic = topic;
			this.rating = rating;
		}
	}

	/**
     * Get survey responses
     * 
     * @return a two-dimensional array of responses. Each cell includes the frequency of ratings for a topic. 
     */
    public int[][] getSurveyResponses() {
        int[][] ratings = new int[surveyTopics.length][RATING_SCALE];
        
        
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        
        System.out.println("<< Welcome to the Survey for Favorite Winter Olympic Sports >>\n");
        System.out.print("Please enter the number of survey respondents: ");
        
        //this try catch clause inside of a do while statement is the big change to the code
        boolean continueLoop = true;        
        do {
        		try {
        			numRespondents = in.nextInt();
        			CallChainMethod1(numRespondents);
        			continueLoop = false;
        			
        		} catch (NegativeNumberOfRespondentsException e) {
        			e.printStackTrace();
				e.getCause();
        			System.err.print("Please enter a positive number for number of respondents ");
        			in.nextLine();
        		}
        		
        		catch (ZeroNumberOfRespondentsException e) {
        			e.printStackTrace();
				e.getCause();
        			System.err.print("Number of respondents must be greater than 0. Try again: ");
        		}
        		
        		catch(InputMismatchException e) {
				e.printStackTrace();
        			System.err.print("Error: you must enter a number. Please enter a valid number: ");
        			in.nextLine();
        		} 

        
        }while(continueLoop);
        
        
        for(int i = 0; i < numRespondents; i++) {
            System.out.println("\nPlease rate the following sports on a scale of 1 (least favoriate) to 10 (most favorite).");
            for(int j = 0; j < surveyTopics.length; j++) {
                System.out.printf("\t%s : ", surveyTopics[j]);
                
                //second place where I inserted effective try catch code inside of a do while statement
                continueLoop = true;
				int rating = 0;
				do {
					try {
						rating = in.nextInt();
						CallChainMethod2(rating);
						continueLoop = false;
						
					}catch(InvalidRatingException e) {
						e.printStackTrace();
						e.getCause();
						System.err.print("Error: "+e.rating +" is not a valid rating. Please try again: ");
						in.nextLine();
						
					}catch(InputMismatchException e) {
						e.printStackTrace();
						e.getCause();
						System.err.print("Please enter a valid integer ");
						in.nextLine();
					}
					
					
				} while (continueLoop);

                	ratings[j][rating-1]++;
            }
        }
        System.out.println();
        
        return ratings;
    }

	/**
	 * Display the ratings and an average rating per topic
	 * 
	 * @param ratings
	 *            ratings from the respondents
	 * @throws NegativeNumberOfRespondentsException, 
	 */
    

//*********************************************
//these are the methods that I create for this class, to chain the exceptions
//first method I use to chain the exception when user enters numbers of responders
    public static void CallChainMethod1(int numRespondents) throws NegativeNumberOfRespondentsException,
    ZeroNumberOfRespondentsException{
    		try {
    			CatchNumUsersExceptions(numRespondents);
    		}catch (NegativeNumberOfRespondentsException e) {
    			throw new NegativeNumberOfRespondentsException("Thrown and chained from CallMethod1", e);
    		}
    		catch (ZeroNumberOfRespondentsException e) {
    			throw new ZeroNumberOfRespondentsException("Thrown and chained from CallMethod1", e);
    		}
    		
    }
    
    public static void CatchNumUsersExceptions(int numRespondents) throws NegativeNumberOfRespondentsException, 
    ZeroNumberOfRespondentsException{
    		if (numRespondents<0)
			throw new NegativeNumberOfRespondentsException();
		if (numRespondents==0)
			throw new ZeroNumberOfRespondentsException();
    }
    
    //CallMethod2 calls MatchPollingException in order to chain the exceptions
    public static void CallChainMethod2(int rating) throws InvalidRatingException{
    		try {
    			CatchPollingException(rating);
    		}catch (InvalidRatingException e) {
    			throw new InvalidRatingException("Thrown and chained from separate method", e);
    		}
    }
    
    //I use this method to chain my exception during the polling
    public static void CatchPollingException(int rating) throws InvalidRatingException{
    		
    	if (rating < 1 || rating >10)
			throw new InvalidRatingException(rating);
    }
//************************************************************
    
	public void displayRatings(int[][] ratings) {

		System.out.printf("%20s", " ");
		for (int i = 0; i < RATING_SCALE; i++) {
			System.out.printf("%10s", "R" + (i + 1));
		}
		System.out.printf("%15s%n", "average");

		for (int i = 0; i < surveyTopics.length; i++) {
			System.out.printf("%-20s", surveyTopics[i]);
			for (int rating : ratings[i]) {
				System.out.printf("%10d", rating);
			}
			System.out.printf("%15.2f", getAverageRating(ratings[i], numRespondents));
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Calculate an average rating for a topic
	 * 
	 * @param ratingsForATopic
	 *            ratings for a topic
	 * @param numRespondents
	 *            the number of respondents
	 * @return
	 */
	public double getAverageRating(int[] ratingsForATopic, int numRespondents) {
		double total = 0;
		for (int i = 0; i < ratingsForATopic.length; i++) {
			total += ratingsForATopic[i] * (i + 1);
		}
		return total / numRespondents;
	}

	/**
	 * Get the topic with the highest total rating
	 * 
	 * @param ratings
	 *            ratings from the respondents
	 * @return
	 */
	public TopicTotalRatingPair getMaxRatings(int[][] ratings) {
		int max = 0;
		String topicWithMaxTotalRating = null;

		for (int i = 0; i < ratings.length; i++) {
			int total = 0;
			for (int j = 0; j < ratings[i].length; j++) {
				total += ratings[i][j] * (j + 1);
			}
			if (total > max) {
				max = total;
				topicWithMaxTotalRating = surveyTopics[i];
			}
		}
		return new TopicTotalRatingPair(topicWithMaxTotalRating, max);
	}

	/**
	 * Get the topic with the lowest total rating
	 * 
	 * @param ratings
	 *            ratings from the respondents
	 * @return
	 */
	public TopicTotalRatingPair getMinRatings(int[][] ratings) {
		int min = Integer.MAX_VALUE;
		String topicWithMinTotalRating = null;

		for (int i = 0; i < ratings.length; i++) {
			int total = 0;
			for (int j = 0; j < ratings[i].length; j++) {
				total += ratings[i][j] * (j + 1);
			}
			if (total < min) {
				min = total;
				topicWithMinTotalRating = surveyTopics[i];
			}
		}
		return new TopicTotalRatingPair(topicWithMinTotalRating, min);
	}

	public static void main(String[] args) {
		PollingExceptionTest o = new PollingExceptionTest();

		int[][] ratings = o.getSurveyResponses();
		o.displayRatings(ratings);

		TopicTotalRatingPair maxRating = o.getMaxRatings(ratings);
		System.out.printf("The most popular Winter Olympic sport was %s with a total rating of %d.%n", maxRating.topic,
				maxRating.rating);

		TopicTotalRatingPair minRating = o.getMinRatings(ratings);
		System.out.printf("The least popular Winter Olympic sport was %s with a total rating of %d.%n", minRating.topic,
				minRating.rating);
	}
}

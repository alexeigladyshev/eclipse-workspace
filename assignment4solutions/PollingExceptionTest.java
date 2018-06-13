import java.util.Scanner;

/**
 * Conduct a survey for favorite Winter Olympic sports. 
 * This class reads ratings from survey respondents and 
 * display the result statistics including average ratings per topic and the highest and lowest rated topics 
 * The input validation in this program is intentionally incomplete
 * 
 * Please do not distribute this code outside the class of SWE510 Fall, 2017
 * 
 * @author Yonghee Shin
 *
 */
public class PollingExceptionTest {
    
    private static final String[] surveyTopics = {"Speed Skating", "Snowboard", "Figure Skating", "Bobsleigh", "Ice Hockey"};
    private static final int RATING_SCALE = 10; // Declaring literals as constants improve code readability and maintainability
    private int numRespondents;
    
    private class TopicTotalRatingPair { // this private inner class is a part of implementation of outter class Polling and not available outside class Polling. 
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
        Scanner in = new Scanner(System.in);
        
        System.out.println("<< Welcome to the Survey for Favorite Winter Olympic Sports >>\n");
        System.out.print("Please enter the number of survey respondents: ");
        
        numRespondents = in.nextInt();
        for(int i = 0; i < numRespondents; i++) {
            System.out.println("\nPlease rate the following sports on a scale of 1 (least favoriate) to 10 (most favorite).");
            for(int j = 0; j < surveyTopics.length; j++) {
                System.out.printf("\t%s : ", surveyTopics[j]);
                int rating = in.nextInt();
                ratings[j][rating-1]++;
            }
        }
        System.out.println();
        
        return ratings;
    }
    
    /**
     * Display the ratings and an average rating per topic
     * 
     * @param ratings ratings from the respondents
     */
    public void displayRatings(int[][] ratings) {
        
        System.out.printf("%20s", " ");
        for(int i = 0; i < RATING_SCALE; i++) {
            System.out.printf("%10s", "R"+(i+1));
        }
        System.out.printf("%15s%n", "average");
        
        for(int i = 0; i < surveyTopics.length; i++) {
            System.out.printf("%-20s", surveyTopics[i]);
            for(int rating : ratings[i]) {
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
     * @param ratingsForATopic ratings for a topic
     * @param numRespondents the number of respondents
     * @return
     */
    public double getAverageRating(int[] ratingsForATopic, int numRespondents) {
        double total = 0;
        for(int i=0; i < ratingsForATopic.length; i++) {
            total += ratingsForATopic[i] * (i+1);
        }
        return total / numRespondents;
    }
    
    /**
     * Get the topic with the highest total rating
     * 
     * @param ratings ratings from the respondents
     * @return
     */
    public TopicTotalRatingPair getMaxRatings(int[][] ratings) {
        int max = 0;
        String topicWithMaxTotalRating = null;
        
        for(int i = 0; i < ratings.length; i++) {
            int total = 0;
            for(int j = 0; j < ratings[i].length; j++) {
                total += ratings[i][j] * (j+1);
            }
            if(total > max) {
                max = total;
                topicWithMaxTotalRating = surveyTopics[i];
            }
        }
        return new TopicTotalRatingPair(topicWithMaxTotalRating, max);
    }
    
    /**
     * Get the topic with the lowest total rating
     * 
     * @param ratings ratings from the respondents
     * @return
     */
    public TopicTotalRatingPair getMinRatings(int[][] ratings) {
        int min = Integer.MAX_VALUE;
        String topicWithMinTotalRating = null;
        
        for(int i = 0; i < ratings.length; i++) {
            int total = 0;
            for(int j = 0; j < ratings[i].length; j++) {
                total += ratings[i][j] * (j+1);
            }
            if(total < min) {
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
        System.out.printf("The most popular Winter Olympic sport was %s with a total rating of %d.%n", maxRating.topic, maxRating.rating);
        
        TopicTotalRatingPair minRating = o.getMinRatings(ratings);
        System.out.printf("The least popular Winter Olympic sport was %s with a total rating of %d.%n", minRating.topic, minRating.rating);
    }
}

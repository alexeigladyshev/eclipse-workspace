//thrown when a user enters a number less than 1 or greater than 10

public class InvalidRatingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int rating;
	
	public InvalidRatingException(int rating) {
		this.rating = rating;
	}
	
	//this constructor has to be here in order to chain the exception
	public InvalidRatingException(String msg, InvalidRatingException e) {
		super(msg, e);
	}

	
}

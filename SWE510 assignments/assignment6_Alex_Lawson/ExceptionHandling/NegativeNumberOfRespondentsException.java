
public class NegativeNumberOfRespondentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NegativeNumberOfRespondentsException() {
		super("NegativeNumberOfRespondentsException");
	}
	
	public NegativeNumberOfRespondentsException(String msg) {
		super(msg);
	}
	
	//this constructor is neseccary in order to chain exceptions, because it accepts an exception as a parameter
	public NegativeNumberOfRespondentsException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	public NegativeNumberOfRespondentsException(Throwable throwable) {
		
		super(throwable);
	}
	
}

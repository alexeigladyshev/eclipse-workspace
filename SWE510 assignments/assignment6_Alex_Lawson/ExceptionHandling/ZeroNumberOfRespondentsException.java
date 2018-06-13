
public class ZeroNumberOfRespondentsException extends RuntimeException{

	//this constructor has to be here in order to chain the exception
	public ZeroNumberOfRespondentsException(String msg, RuntimeException e) {
		super(msg, e);
	}

	public ZeroNumberOfRespondentsException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

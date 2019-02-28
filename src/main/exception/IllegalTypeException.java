package main.exception;

public class IllegalTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1378963596855877144L;
	
	public IllegalTypeException() {}
	
	public IllegalTypeException(String message) {
		super(message);
	}

}

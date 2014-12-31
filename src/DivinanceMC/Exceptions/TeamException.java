package DivinanceMC.Exceptions;

public class TeamException extends Exception {
	
	private String message;
	
	public TeamException (String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

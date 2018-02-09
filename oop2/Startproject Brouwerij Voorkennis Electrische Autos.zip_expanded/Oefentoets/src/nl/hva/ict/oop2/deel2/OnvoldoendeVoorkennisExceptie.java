package nl.hva.ict.oop2.deel2;

public class OnvoldoendeVoorkennisExceptie extends Exception {

	public OnvoldoendeVoorkennisExceptie() {
	}

	public OnvoldoendeVoorkennisExceptie(String message) {
		super(message);
	}

	public OnvoldoendeVoorkennisExceptie(Throwable cause) {
		super(cause);
	}

	public OnvoldoendeVoorkennisExceptie(String message, Throwable cause) {
		super(message, cause);
	}

	public OnvoldoendeVoorkennisExceptie(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

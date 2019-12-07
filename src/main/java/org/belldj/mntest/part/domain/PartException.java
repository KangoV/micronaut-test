package org.belldj.mntest.part.domain;

public class PartException extends RuntimeException {

	public PartException() {
		super();
	}

	public PartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PartException(String message, Throwable cause) {
		super(message, cause);
	}

	public PartException(String message) {
		super(message);
	}

	public PartException(Throwable cause) {
		super(cause);
	}

}

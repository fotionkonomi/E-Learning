package com.learning.be.common.exception;

import lombok.Getter;
import lombok.Setter;

public class ELearningRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 8533675949033551972L;

	@Getter
	@Setter
	private String messageKey;
	
	public ELearningRuntimeException(String messageKey) {
		this(messageKey, "");
	}
	
	public ELearningRuntimeException(String messageKey, String message) {
		this(messageKey, message, null);
	}
	
	public ELearningRuntimeException(String messageKey, String message, Throwable t) {
		super(message, t);
		this.messageKey = messageKey;
	}
	
	public ELearningRuntimeException(String messageKey, Throwable t) {
		super(t);
		this.messageKey = messageKey;
	}
}

package com.learning.be.common.exception;

import com.learning.be.common.constants.MessageConstants;

public class ConstraintException extends ELearningRuntimeException {
	private static final long serialVersionUID = 4565889756411355150L;

	public ConstraintException() {
		super(MessageConstants.MSG_CONSTRAINT_EXCEPTION);
	}

	public ConstraintException(String message) {
		super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, message);
	}
	
	public ConstraintException(String message, Throwable t) {
		super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, message, t);
	}
	
	public ConstraintException(Throwable t) {
		super(MessageConstants.MSG_CONSTRAINT_EXCEPTION, t);
	}
	
	protected ConstraintException(String messageConstant, String message, Throwable t) {
		super(messageConstant, message, t);
	}
	
}

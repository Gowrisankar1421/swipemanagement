package com.example.swipemangement.exception;

@SuppressWarnings("serial")
public class NoEmployeeDataFoundException extends RuntimeException{
	public NoEmployeeDataFoundException() {
		super("NoEmployeeFoundException");
	}

}

package com.spc.comunity.util;

import org.springframework.http.HttpStatus;

public class ResultResponse<T> {
	
	private int code;
	private int status;
	private String message;
	private T result;
	
	public ResultResponse(T result) {
		this.result = result;
		this.status = HttpStatus.OK.value();
		this.message = "Success";
	}
	
	public ResultResponse() {
		this.status = HttpStatus.OK.value();
		this.message = "Success";
	}
	
	public ResultResponse(int status, String message, int code) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

}

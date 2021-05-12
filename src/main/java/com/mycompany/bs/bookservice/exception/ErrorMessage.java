package com.mycompany.bs.bookservice.exception;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor
public class ErrorMessage {
	
	private Integer statusCode;
	private String message;
	private Instant instant;
	
}

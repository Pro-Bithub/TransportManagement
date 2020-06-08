package com.prakash.tm.exception;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	// General error message about nature of error
	private String message;

	// Specific errors in API request processing
	private List<String> details;
}
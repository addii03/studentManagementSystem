package student_management_system.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomStudentManagementException.class)

	public ResponseEntity<?> handleCustomException(CustomStudentManagementException exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false),
				new Date(4));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception1, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(exception1.getMessage(), webRequest.getDescription(false),
				new Date(4));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

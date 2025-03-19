package truong2k4.identityService.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import truong2k4.identityService.dtos.response.ApiResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
		log.error("Exception: ", exception);
		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
		apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

		return ResponseEntity.badRequest().body(apiResponse);
	}
	  @ExceptionHandler(value = AccessDeniedException.class)
	    ResponseEntity<ApiResponse> handlingAccessDeniedException(AccessDeniedException exception) {
	        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

	        return ResponseEntity.status(errorCode.getHttpStatusCode())
	                .body(ApiResponse.builder()
	                        .code(errorCode.getCode())
	                        .message(errorCode.getMessage())
	                        .build());
	    }
	

	@ExceptionHandler(value = AppException.class)
	ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
		ErrorCode errorCode = exception.getErrorCode();
		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());

		return ResponseEntity.status(errorCode.getHttpStatusCode()).body(apiResponse);
	}

	
}
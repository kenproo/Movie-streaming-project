package truong2k4.identityService.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
	USER_EXISTED(1001, "User is existed", HttpStatus.BAD_REQUEST),
	UNAUTHENTICATED(1002, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    USER_NOT_EXIST(1003, "User is not existed", HttpStatus.NOT_FOUND),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized ", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(1004, "Unauthorized", HttpStatus.UNAUTHORIZED);
	
	private ErrorCode(int code, String message, HttpStatus httpStatusCode) {
		this.code = code;
		this.message = message;
		this.httpStatusCode = httpStatusCode;
	}

	private int code;
	private String message;
	private HttpStatus httpStatusCode;
}

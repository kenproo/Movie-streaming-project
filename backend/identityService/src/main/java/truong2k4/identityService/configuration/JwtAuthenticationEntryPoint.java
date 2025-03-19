package truong2k4.identityService.configuration;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import truong2k4.identityService.dtos.response.ApiResponse;
import truong2k4.identityService.exception.ErrorCode;
@Slf4j
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint{
	  @Override
	    public void commence(
	            HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	            throws IOException {
	        ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;
	        response.setStatus(errorCode.getHttpStatusCode().value());
	        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

	        ApiResponse<?> apiResponse = ApiResponse.builder()
	                .code(errorCode.getCode())
	                .message(errorCode.getMessage())
	                .build();

	        ObjectMapper objectMapper = new ObjectMapper();

	        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
	        response.flushBuffer();
	    }
}

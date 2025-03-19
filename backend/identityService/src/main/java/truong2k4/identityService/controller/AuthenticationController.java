package truong2k4.identityService.controller;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.ErrorReportConfiguration.Builder;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import truong2k4.identityService.dtos.request.AuthenticationRequest;
import truong2k4.identityService.dtos.request.IntrospectRequest;
import truong2k4.identityService.dtos.request.RefreshRequest;
import truong2k4.identityService.dtos.response.ApiResponse;
import truong2k4.identityService.dtos.response.AuthenticationResponse;
import truong2k4.identityService.dtos.response.IntrospectResponse;
import truong2k4.identityService.service.AuthenticationService;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
	
	AuthenticationService authenticationService;
   @PostMapping("/token")
   ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
		var result = authenticationService.authenticate(authenticationRequest);
		return ApiResponse.<AuthenticationResponse>builder().result(result).build();
   }
   
   @PostMapping("/introspect")
   ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest introspectRequest){
	   var result = authenticationService.introspect(introspectRequest);
	   return ApiResponse.<IntrospectResponse>builder().result(result).build();
	   
   }
   
   @PostMapping("/refresh")
   ApiResponse<AuthenticationResponse> refreshToken(@RequestBody RefreshRequest refreshRequest) throws ParseException, JOSEException{
	   var result = authenticationService.refreshToken(refreshRequest);
	   return ApiResponse.<AuthenticationResponse>builder().result(result).build();
	   
   }
   
   
}

package truong2k4.identityService.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import truong2k4.identityService.dtos.request.UserCreationRequest;
import truong2k4.identityService.dtos.request.UserUpdateRequest;
import truong2k4.identityService.dtos.response.ApiResponse;
import truong2k4.identityService.dtos.response.UserResponse;
import truong2k4.identityService.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
	UserService userService;

	@PostMapping("/register")
	ApiResponse<UserResponse> createUser(@RequestBody UserCreationRequest userCreationRequest) {
		return ApiResponse.<UserResponse>builder().result(userService.createUser(userCreationRequest)).build();
	}
	
	  @GetMapping
	    ApiResponse<List<UserResponse>> getUsers() {
	        return ApiResponse.<List<UserResponse>>builder()
	                .result(userService.getUsers())
	                .build();
	    }

	    @GetMapping("/{userId}")
	    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
	        return ApiResponse.<UserResponse>builder()
	                .result(userService.getUser(userId))
	                .build();
	    }

	    @GetMapping("/my-info")
	    ApiResponse<UserResponse> getMyInfo() {
	        return ApiResponse.<UserResponse>builder()
	                .result(userService.getMyInfo())
	                .build();
	    }

	    @DeleteMapping("/{userId}")
	    ApiResponse<String> deleteUser(@PathVariable String userId) {
	        userService.deleteUser(userId);
	        return ApiResponse.<String>builder().result("User has been deleted").build();
	    }

	    @PutMapping("/{userId}")
	    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
	        return ApiResponse.<UserResponse>builder()
	                .result(userService.updateUser(userId, request))
	                .build();
	    }

}

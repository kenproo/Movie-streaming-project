package truong2k4.identityService.repository.httpclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import truong2k4.identityService.dtos.request.ProfileCreationRequest;

@FeignClient(name = "profile-service")
public interface ProfileClient {
  @PostMapping(value ="/profile/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
   Object createProfile(@RequestBody ProfileCreationRequest reuest);
  
}

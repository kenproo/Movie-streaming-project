package truong2k4.identityService.dtos.response;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import truong2k4.identityService.entity.Role;
import truong2k4.identityService.entity.User;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
	String idUser;
	String username;
	String password;
	 Set<Role> roles; 
}

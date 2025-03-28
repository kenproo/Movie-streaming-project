package truong2k4.identityService.dtos.request;

import java.time.LocalDate;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
	String username;
	String password;
	String firstname;
	String lastname;
	List<String> roles;
}

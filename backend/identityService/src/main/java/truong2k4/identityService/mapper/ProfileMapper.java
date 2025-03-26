package truong2k4.identityService.mapper;

import org.mapstruct.Mapper;

import truong2k4.identityService.dtos.request.ProfileCreationRequest;
import truong2k4.identityService.dtos.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest userCreationRequest);
}

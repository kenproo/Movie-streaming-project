package truong2k4.identityService.mapper;
import org.mapstruct.Mapper;
import truong2k4.identityService.dtos.request.PermissionRequest;
import truong2k4.identityService.dtos.response.PermissionResponse;
import truong2k4.identityService.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
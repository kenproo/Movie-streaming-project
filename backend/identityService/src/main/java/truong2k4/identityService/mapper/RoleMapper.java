package truong2k4.identityService.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import truong2k4.identityService.dtos.request.RoleRequest;
import truong2k4.identityService.dtos.response.RoleResponse;
import truong2k4.identityService.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
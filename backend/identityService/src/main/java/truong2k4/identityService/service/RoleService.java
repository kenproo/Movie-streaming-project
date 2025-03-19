package truong2k4.identityService.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import truong2k4.identityService.dtos.request.RoleRequest;
import truong2k4.identityService.dtos.response.RoleResponse;
import truong2k4.identityService.mapper.RoleMapper;
import truong2k4.identityService.repository.PermissionRepository;
import truong2k4.identityService.repository.RoleRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level =AccessLevel.PRIVATE,makeFinal = true)
public class RoleService {
	 RoleRepository roleRepository;
	    PermissionRepository permissionRepository;
	    RoleMapper roleMapper;

	    public RoleResponse create(RoleRequest request){
	        var role = roleMapper.toRole(request);

	        var permissions = permissionRepository.findAllById(request.getPermissions());
	        role.setPermissions(new HashSet<>(permissions));

	        role = roleRepository.save(role);
	        return roleMapper.toRoleResponse(role);
	    }

	    public List<RoleResponse> getAll(){
	        return roleRepository.findAll()
	                .stream()
	                .map(roleMapper::toRoleResponse)
	                .toList();
	    }

	    public void delete(String role){
	        roleRepository.deleteById(role);
	    }
}

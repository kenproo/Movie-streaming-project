package truong2k4.identityService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import truong2k4.identityService.entity.Role;
@Repository
public interface RoleRepository  extends JpaRepository<Role, String >{
}

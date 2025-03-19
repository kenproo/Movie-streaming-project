package truong2k4.identityService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import truong2k4.identityService.entity.InvalidatedToken;

@Repository
public interface InvalidatedTokenRepository  extends JpaRepository<InvalidatedToken, String>{

}

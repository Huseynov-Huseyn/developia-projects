package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava13.entity.UserEntity;
import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
	@Query(value = "update users set username=?2 where username=?1", nativeQuery = true)
	@Modifying
	void updateMyUsername(String username, String newUsername);
}

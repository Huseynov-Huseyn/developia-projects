package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springjava13.entity.AuthorityEntity;
import jakarta.transaction.Transactional;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {

	@Query(value = "delete fromt authorities where username=?1", nativeQuery = true)
	@Modifying
	void deleteUserAuthorities(String username);// Farid1905

	@Query(value = "delete fromt authorities where username=?1 and authority=?2", nativeQuery = true)
	@Modifying
	void deleteUserAuthority(String username, String authority);// Farid1905, ROLE_ADD_STUDENT
}

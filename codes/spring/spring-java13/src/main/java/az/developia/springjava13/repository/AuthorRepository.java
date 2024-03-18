package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

	AuthorEntity findByUsername(String username);

}

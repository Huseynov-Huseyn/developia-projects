package az.developia.springjava13.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	public Optional<UserEntity> findById(String username) {
		Optional<UserEntity> byId = repository.findById(username);
		return byId;
	}

	public void updateMyUsername(String username, String newUsername) {
		repository.updateMyUsername(username, newUsername);
	}

	public void deleteById(String username) {
		repository.deleteById(username);
	}

}

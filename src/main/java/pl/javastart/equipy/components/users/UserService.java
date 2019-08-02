package pl.javastart.equipy.components.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	List<UserDto> findAll(){
		return userRepository.findAll()
				.stream()
				.map(UserMapper::toDto)
				.collect(Collectors.toList());
	}
}

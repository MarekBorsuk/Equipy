package pl.java.equipy.users;

import java.util.List;
import java.util.Optional;
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
	
	List<UserDto> findByLastName(String lastName){
		return userRepository.findAllByLastNameContainingIgnoreCase(lastName)
				.stream()
				.map(UserMapper::toDto)
				.collect(Collectors.toList());
	}
	
	Optional<UserDto> findById(Long id){
		return userRepository.findById(id).map(UserMapper::toDto);
	}
	
	UserDto save(UserDto user) {
		Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
		userByPesel.ifPresent( u -> {
			throw new DuplicatePeselException();
		});
		User userEntity = UserMapper.toEntity(user);
		User savedUser = userRepository.save(userEntity);
		return UserMapper.toDto(savedUser);
	}
	
	UserDto update(UserDto user) {
		Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
		userByPesel.ifPresent(u ->{
			if (!u.getId().equals(user.getId())) {
				throw new DuplicatePeselException();
			}
		});
		return mapAndSaveUser(user);
	}

	private UserDto mapAndSaveUser(UserDto user) {
		User userEntity = UserMapper.toEntity(user);
		User savedUser = userRepository.save(userEntity);
		return UserMapper.toDto(savedUser);
	}
}

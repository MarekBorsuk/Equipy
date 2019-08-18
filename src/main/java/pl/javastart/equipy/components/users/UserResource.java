package pl.javastart.equipy.components.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	private UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("")
	List<UserDto> findAll(@RequestParam(required = false) String lastName){
		if (lastName != null) {
			return userService.findByLastName(lastName);
		} else{
			return userService.findAll();
		}		
	}
	
	@PostMapping("")
	public ResponseEntity<UserDto> save(@RequestBody UserDto user){
		if (user.getId()!= null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Zapisywany obiekt nie może mieć ustawionego id.");		
		}
		UserDto savadeUser = userService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savadeUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(savadeUser);
	}
}

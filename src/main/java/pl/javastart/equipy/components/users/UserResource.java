package pl.javastart.equipy.components.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable Long id){
		return userService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto user){
		if (!id.equals(user.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt musi mieć id zgodne z id w ścieżce zasobu");
		}
		UserDto updateUser = userService.update(user);
		return ResponseEntity.ok(updateUser);
	}
}

package pl.java.equipy.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak użytkownika o takim ID")
public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 8661999795538255918L;

}

package pl.java.equipy.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim peselem już istnieje.")
class DuplicatePeselException extends RuntimeException {


	private static final long serialVersionUID = -211825209320495576L;

}

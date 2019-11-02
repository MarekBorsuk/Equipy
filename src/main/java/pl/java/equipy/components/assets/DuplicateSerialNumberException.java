package pl.java.equipy.components.assets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Produkt ma już przypisany taki numer seryjny.")
public class DuplicateSerialNumberException extends RuntimeException {

	private static final long serialVersionUID = -5266391229291258228L;

	

}

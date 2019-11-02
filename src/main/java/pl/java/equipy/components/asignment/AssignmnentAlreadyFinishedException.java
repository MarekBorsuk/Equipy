package pl.java.equipy.components.asignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "To przypisanie już zostało zakończone.")
public class AssignmnentAlreadyFinishedException  extends RuntimeException{

	private static final long serialVersionUID = 982705149117718060L;

}

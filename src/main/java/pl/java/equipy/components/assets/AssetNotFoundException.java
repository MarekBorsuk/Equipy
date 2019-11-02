package pl.java.equipy.components.assets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak wyposażenia o takim ID")
public class AssetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6896771862127247258L;

}

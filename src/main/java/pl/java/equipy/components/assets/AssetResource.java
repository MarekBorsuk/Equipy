package pl.java.equipy.components.assets;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assets")
public class AssetResource {

	private AssetService assetService;
	
	public AssetResource(AssetService assetService) {
		this.assetService = assetService;
	}
	
	@GetMapping("")
	public List<AssetDto> findAll(){
		return assetService.findAll();
	}
}

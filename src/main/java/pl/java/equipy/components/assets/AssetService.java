
package pl.java.equipy.components.assets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AssetService {

	private AssetRepository assetRepository;
	private AssetMapper assetMapper;
	
	public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
		this.assetRepository = assetRepository;
		this.assetMapper = assetMapper;
	}
	
	List<AssetDto> findAll(){
		return assetRepository.findAll()
				.stream()
				.map(assetMapper::toDto)
				.collect(Collectors.toList());
	}
}

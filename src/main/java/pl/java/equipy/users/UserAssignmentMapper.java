package pl.java.equipy.users;

import pl.java.equipy.components.asignment.Assignment;
import pl.java.equipy.components.assets.Asset;

public class UserAssignmentMapper {
	
	static UserAssignmentDto toDto(Assignment assignment) {
		
		UserAssignmentDto dto = new UserAssignmentDto();
		dto.setId(assignment.getId());
		dto.setAssetId(assignment.getId());
		dto.setStart(assignment.getStart());
		dto.setStart(assignment.getStart());
		dto.setEnd(assignment.getEnd());
		Asset asset = assignment.getAsset();
		dto.setAssetName(asset.getName());
		dto.setAssetSerialName(asset.getSerialNumber());
		
		return dto;
		
	}

	
	
	
}

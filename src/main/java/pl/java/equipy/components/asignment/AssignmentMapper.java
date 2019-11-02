package pl.java.equipy.components.asignment;

import pl.java.equipy.components.assets.Asset;
import pl.java.equipy.users.User;

public class AssignmentMapper {

	static AssignmentDto toDto(Assignment assignment) {
		
		AssignmentDto dto = new AssignmentDto();
		dto.setId(assignment.getId());
		dto.setStart(assignment.getStart());
		dto.setEnd(assignment.getEnd());
		User user = assignment.getUser();
		dto.setUserId(user.getId());
		Asset asset = assignment.getAsset();
		dto.setAssetId(asset.getId());
		
		return dto;
	}
}

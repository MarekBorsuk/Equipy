package pl.java.equipy.components.asignment;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentResource {

	private AssignmentService assignmentService;

	public AssignmentResource(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}
	
	@PostMapping("")
	public ResponseEntity<AssignmentDto> saveAssignment(@RequestBody AssignmentDto assignment){
		
		AssignmentDto savedAssignment;
		try {
			savedAssignment = assignmentService.createAssignment(assignment);
		}catch(InvalidAssignmentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAssignment.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(savedAssignment);		
	}
	@PostMapping("/{id}/end")
	public ResponseEntity finishAssigmnet(@PathVariable Long id) {
		LocalDateTime endDate = assignmentService.finishAssignment(id);
		return ResponseEntity.accepted().body(endDate);
	}
	
	
	
}

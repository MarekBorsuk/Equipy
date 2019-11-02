package pl.java.equipy.users;

import java.time.LocalDateTime;

public class UserAssignmentDto {
	
	private Long id;
	private LocalDateTime start;
	private LocalDateTime end;
	private Long assetId;
	private String assetName;
	private String assetSerialName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetSerialName() {
		return assetSerialName;
	}
	public void setAssetSerialName(String assetSerialName) {
		this.assetSerialName = assetSerialName;
	}
	
	

}

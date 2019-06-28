package com.project.dto;


import java.util.HashSet;
import java.util.Set;

public class PermissionDtoCollection {

	private Set<PermissionDto> permissionDtoSet = new HashSet<PermissionDto>();

	public Set<PermissionDto> getPermissionDtoSet() {
		return permissionDtoSet;
	}

	public void setPermissionDtoSet(Set<PermissionDto> permissionDtoSet) {
		this.permissionDtoSet = permissionDtoSet;
	}
}

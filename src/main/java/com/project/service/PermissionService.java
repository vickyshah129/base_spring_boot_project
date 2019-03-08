package com.project.service;

import com.project.entity.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> getAllPermission();

    public Permission addOrUpdatePermission(Permission permission);

    public Permission getPermissionById(Long id);
}

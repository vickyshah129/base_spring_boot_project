package com.project.service;

import com.project.entity.Permission;
import com.project.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission addOrUpdatePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission getPermissionById(Long id) {
        Optional<Permission> optional = permissionRepository.findById(id);
        if(!optional.equals(null)){
            return optional.get();
        }
        return null;
    }
}

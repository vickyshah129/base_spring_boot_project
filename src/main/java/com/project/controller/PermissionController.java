package com.project.controller;

import com.project.dto.PermissionDto;
import com.project.dto.PermissionDtoCollection;
import com.project.entity.Permission;
import com.project.service.PermissionService;
import com.project.translator.PermissionTranslator;
import com.project.util.Status;
import com.project.util.StatusMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionTranslator permissionTranslator;


    @GetMapping("/{permission_id}")
    public PermissionDto getPermissionById(@PathVariable("permission_id") Long permissionId) {
        Permission permission = permissionService.getPermissionById(permissionId);
        PermissionDto permissionDto = (PermissionDto) permissionTranslator.translateToDTO(permission);
        return response(permissionDto);
    }

    @GetMapping
    public List<Permission> getAllPermissions() {
        List<Permission> permissions = permissionService.getAllPermission();
        return response(permissions);
    }

    @PostMapping
    public Status addPermission(@RequestBody PermissionDtoCollection permissionDtoCollection) {
        Set<PermissionDto> permissionDtoSet = permissionDtoCollection.getPermissionDtoSet();
        AtomicBoolean errorOccured = new AtomicBoolean(false);
        permissionDtoSet.forEach(permissionDto -> {
            Permission permission = (Permission) permissionTranslator.translateToEntity(permissionDto);
            permissionService.addOrUpdatePermission(permission);
        });
        return response(StatusMessage.PERMISSION_ADDED_SUCCESSFULLY);
    }

    @PutMapping
    public Status updatePermission(@RequestBody PermissionDto permissionDto) throws Exception{
        permissionTranslator.validateRequestDto(permissionDto);
        Permission permission = permissionService.getPermissionById(permissionDto.getId());
        permissionTranslator.translateToEntity(permissionDto);
        permissionService.addOrUpdatePermission(permission);
        return response(StatusMessage.ROLE_ADDED_SUCCESSFULLY, permission.getId());
    }
}
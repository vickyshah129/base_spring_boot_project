package com.project.translator;

import com.project.dto.PermissionDto;
import com.project.entity.Permission;
import com.project.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PermissionTranslator implements Translator{

    @Override
    public Object translateToEntity(Object t) {
        Permission permission = new Permission();
        PermissionDto permissionDto = (PermissionDto) t;
        BeanUtils.copyProperties(permissionDto,permission);
        validateValues(permission);
        return permission;
    }

    public void validateValues(Permission permission){
        if(permission.getId() == null || permission.getId() <= 0){
            permission.setDateCreation(Utils.getUTCTime());
        }else{
            permission.setDateUpdate(Utils.getUTCTime());
        }
    }

    @Override
    public Object translateToDTO(Object t) {
        Permission permission = (Permission) t;
        PermissionDto permissionDto = new PermissionDto();
        BeanUtils.copyProperties(permission,permissionDto);
        return permissionDto;
    }

    @Override
    public void translateDtoToEntity(Object o, Object o2) {

    }

    public void validateRequestDto(PermissionDto permissionDto) throws Exception {
        if(permissionDto.getName() == null || permissionDto.getName().isEmpty()){
            throw new Exception("Please specify name");
        }
    }
}

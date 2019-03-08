package com.project.repository;

import com.project.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    /*public List<Sale> findAll();
    public List<Sale> findAllByCustomerId(int id);
    public Sale save(Sale s);*/
}

package com.project.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface JdbcRepository {

    void doSomething();

    boolean deleteUserRolesFromDatabase(int id);
}

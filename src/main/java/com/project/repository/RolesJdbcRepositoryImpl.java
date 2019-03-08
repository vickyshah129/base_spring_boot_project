package com.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class JdbcRepositoryImpl implements JdbcRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void doSomething() {
        /*String query = "select count(*) from roles";
        int result = jdbcTemplate.queryForObject(query,Integer.class);
        System.out.println(result+" ROLES found.");
        Roles role = getRoleById();
        System.out.println("Employee ID= "+role.getId());*/
    }

    @Override
    public boolean deleteUserRolesFromDatabase(int id) {
        String query = "delete from user_roles where user_id=?";
        jdbcTemplate.update(query,new Object[]{id});
        return true;
    }

    /*public Roles getRoleById(){
        String query = "select * from roles where id=?";
        Roles roleObj = jdbcTemplate.queryForObject(query, new Object[]{31},new RowMapper<Roles>(){
            public Roles mapRow(ResultSet rs, int rowNum)throws SQLException{
                Roles role = new Roles();
                role.setId(rs.getLong("id"));
                return role;
            }
            });
        return roleObj;
    }*/

}

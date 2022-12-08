package com.demo.dashboard.repository.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setIdUser(rs.getInt("ID_USER"));
        user.setNamecustomer(rs.getString("NA_NAME_CUSTOMER"));
        user.setIdRol(rs.getInt("ID_ROLE"));
        //user.setToken(rs.getString("DE_TOKEN"));

        return user;
    }
}

package ru.gvozdilin.waterCounter.mapper;


import org.springframework.jdbc.core.RowMapper;
import ru.gvozdilin.waterCounter.entity.House;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseMapper implements RowMapper<House> {
    @Override
    public House mapRow(ResultSet rs, int rowNum) throws SQLException {
        House house = new House();
        house.setAddress(rs.getString("address"));
        house.setId(rs.getLong("id"));
        house.setIndication(rs.getLong("indication"));
        return house;
    }
}

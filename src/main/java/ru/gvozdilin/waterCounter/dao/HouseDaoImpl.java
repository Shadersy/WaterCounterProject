package ru.gvozdilin.waterCounter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.gvozdilin.waterCounter.entity.House;
import ru.gvozdilin.waterCounter.mapper.HouseMapper;

import javax.sql.DataSource;

import java.util.List;

@Repository
public class HouseDaoImpl implements HouseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @Override
    public List<House> findAllHouses() {
        return jdbcTemplate.query("SELECT * FROM house", new HouseMapper());
    }

    public void createHouse(String address) {
        jdbcTemplate.update("INSERT into house (address) VALUES (?)", address);
    }

    public void deleteHouse(Long id) {
        jdbcTemplate.update("DELETE from house where id = ?", id);
    }

    public void setIndication(Long indication, Long id){
        jdbcTemplate.update("UPDATE house set indication = ? where id = ?", indication, id);
    }

    @Override
    public List<House> showMaxIndication() {
        return jdbcTemplate.query("SELECT id, address, MAX(indication) as indication from house", new HouseMapper());
    }


}

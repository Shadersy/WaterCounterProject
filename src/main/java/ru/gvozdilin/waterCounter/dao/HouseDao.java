package ru.gvozdilin.waterCounter.dao;

import org.springframework.stereotype.Repository;
import ru.gvozdilin.waterCounter.entity.House;

import java.util.List;


public interface HouseDao {
    public List<House> findAllHouses();
    public void createHouse(String address);
    public void deleteHouse(Long id);
    public void setIndication(Long indication, Long id);
    public List<House> showMaxIndication();
}


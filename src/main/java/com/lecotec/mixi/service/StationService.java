package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Station;
import com.lecotec.mixi.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Page<Station> getStations(int pageNumber, int pageSize) {
        return stationRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return stationRepository.changeActiveStatus(id, isActive, new Date()) > 0;
    }

    public boolean deleteStation(long id) {
        stationRepository.deleteById(id);
        return true;
    }
}

package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Station;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.StationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/merchant/station")
@Api(tags = "站点信息接口")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("all")
    public BootstrapTableResult<Station> getStations(int pageNumber, int pageSize) {
        Page<Station> stations = stationService.getStations(pageNumber, pageSize);
        return new BootstrapTableResult<>(stations.getTotalElements(), stations.getContent());
    }

    @PostMapping
    public ResponseObject saveOrUpdateStation(@Valid @RequestBody Station station) {
        return new SuccessResponse(stationService.saveStation(station));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(stationService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteStation(@PathVariable("id") long id) {
        return new SuccessResponse(stationService.deleteStation(id));
    }
}

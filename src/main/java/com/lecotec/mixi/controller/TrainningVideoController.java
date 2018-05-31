package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.TrainningVideo;
import com.lecotec.mixi.model.parameter.TrainningVideoSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.TrainningVideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "骑手培训视频接口")
public class TrainningVideoController {
    @Autowired
    private TrainningVideoService trainningVideoService;

    @PostMapping("/api/merchant/trainningVideo")
    public ResponseObject saveOrUpdate(@Valid @RequestBody TrainningVideo trainningVideo) {
        return new SuccessResponse(trainningVideoService.saveOrUpdate(trainningVideo));
    }

    @GetMapping("/api/merchant/trainningVideo/searchForConsole")
    public BootstrapTableResult<TrainningVideo> searchForConsole(TrainningVideoSearchParam trainningVideoSearchParam) {
        Page<TrainningVideo> result = trainningVideoService.searchForConsole(trainningVideoSearchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @PutMapping("/api/merchant/trainningVideo/changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(trainningVideoService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/api/merchant/trainningVideo/{id}")
    public ResponseObject deleteById(@PathVariable("id") long id) {
        return new SuccessResponse(trainningVideoService.deleteById(id));
    }
}
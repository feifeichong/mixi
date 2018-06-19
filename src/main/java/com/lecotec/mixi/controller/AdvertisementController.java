package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Advertisement;
import com.lecotec.mixi.model.entity.Question;
import com.lecotec.mixi.model.parameter.AdvertisementSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.AdvertisementService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "轮播广告接口")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/api/merchant/advertisement")
    public ResponseObject saveOrUpdate(@Valid @RequestBody Advertisement question) {
        return new SuccessResponse(advertisementService.saveOrUpdate(question));
    }

    @GetMapping("/api/merchant/advertisement/searchForConsole")
    public BootstrapTableResult<Advertisement> searchForConsole(AdvertisementSearchParam advertisementSearchParam) {
        Page<Advertisement> result = advertisementService.searchForConsole(advertisementSearchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @PutMapping("/api/merchant/advertisement/changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(advertisementService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/api/merchant/advertisement/{id}")
    public ResponseObject deleteById(@PathVariable("id") long id) {
        return new SuccessResponse(advertisementService.deleteById(id));
    }

    @PostMapping("/api/merchant/advertisement/deleteBatch")
    public ResponseObject deleteBatch(@RequestBody long[] ids) {
        return new SuccessResponse(advertisementService.deleteBatch(ids));
    }
}

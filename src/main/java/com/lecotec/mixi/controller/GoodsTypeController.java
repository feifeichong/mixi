package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.GoodsType;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("/{id}")
    public ResponseObject getGoodsType(@PathVariable("id") long id) {
        return new SuccessResponse(goodsTypeService.getGoodsTypeById(id));
    }

    @GetMapping("all")
    public BootstrapTableResult<GoodsType> getGoodsTypes(int pageNumber, int pageSize) {
        Page<GoodsType> goodsTypes = goodsTypeService.getGoodsTypes(pageNumber, pageSize);
        return new BootstrapTableResult<>(goodsTypes.getTotalElements(), goodsTypes.getContent());
    }

    @PostMapping
    public ResponseObject saveGoodsType(@Valid @RequestBody GoodsType goodsType) {
        return new SuccessResponse(goodsTypeService.saveGoodsType(goodsType));
    }

    @PutMapping
    public ResponseObject updateGoodsType(@Valid @RequestBody GoodsType goodsType) {
        return new SuccessResponse(goodsTypeService.updateGoodsType(goodsType));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(goodsTypeService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteGoodsType(@PathVariable("id") long id) {
        return new SuccessResponse(goodsTypeService.deleteGoodsType(id));
    }
}
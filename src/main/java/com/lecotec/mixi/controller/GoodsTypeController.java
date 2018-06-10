package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.GoodsType;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.GoodsService;
import com.lecotec.mixi.service.GoodsTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/merchant/goodsType")
@Api(tags = "商品类型接口")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private GoodsService goodsService;

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

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(goodsTypeService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteGoodsType(@PathVariable("id") long id) {
        return goodsService.isExistGoodsByGoodsTypeId(id)
                ? new FailResponse("当前菜品类型下面还有菜品信息")
                : new SuccessResponse(goodsTypeService.deleteGoodsType(id));
    }
}
package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.parameter.GoodsSearchParam;
import com.lecotec.mixi.model.parameter.IdsParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "商品数据维护接口")
@RequestMapping("/api/merchant/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public ResponseObject saveOrUpdateGoods(@Valid @RequestBody Goods goods) {
        return new SuccessResponse(goodsService.saveGoods(goods));
    }

    @GetMapping("searchByParam")
    public BootstrapTableResult<Goods> searchByParam(GoodsSearchParam goodsSearchParam) {
        Page<Goods> goodsPage = goodsService.searchByParam(goodsSearchParam);
        return new BootstrapTableResult<>(goodsPage.getTotalElements(), goodsPage.getContent());
    }

    @PostMapping("searchByIds")
    public BootstrapTableResult<Goods> searchByIds(@RequestBody IdsParam idsParam) {
        Page<Goods> goodsPage = goodsService.searchByIds(idsParam);
        return new BootstrapTableResult<>(goodsPage.getTotalElements(), goodsPage.getContent());
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(goodsService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteGoods(@PathVariable("id") long id) {
        return new SuccessResponse(goodsService.deleteGoods(id));
    }
}
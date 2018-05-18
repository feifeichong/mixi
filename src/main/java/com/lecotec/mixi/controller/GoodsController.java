package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "商品数据维护接口")
@RequestMapping("/api/merchant/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public ResponseObject saveGoods(@Valid @RequestBody Goods goods) {
        return new SuccessResponse(goodsService.saveGoods(goods));
    }
}

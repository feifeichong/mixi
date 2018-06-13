package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.GoodsTag;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.GoodsTagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/goodsTag")
@Api(tags = "商品标签接口")
public class GoodsTagController {

    @Autowired
    private GoodsTagService goodsTagService;

    @GetMapping("all")
    public BootstrapTableResult<GoodsTag> getAll(int pageNumber, int pageSize) {
        Page<GoodsTag> result = goodsTagService.getAll(pageNumber, pageSize);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody GoodsTag GoodsTag) {
        return new SuccessResponse(goodsTagService.saveOrUpdate(GoodsTag));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(goodsTagService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable("id") long id) {
        return new SuccessResponse(goodsTagService.delete(id));
    }
}
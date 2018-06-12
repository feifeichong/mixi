package com.lecotec.mixi.controller;

import com.lecotec.mixi.service.GoodsToTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant/goodsToTag")
public class GoodsToTagController {
    @Autowired
    private GoodsToTagService goodsToTagService;
}

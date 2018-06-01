package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.PushedMessage;
import com.lecotec.mixi.model.parameter.PushedMessageSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.PushedMessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "系统推送消息接口")
public class PushedMessageController {
    @Autowired
    private PushedMessageService pushedMessageService;

    @PostMapping("/api/merchant/pushedMessage")
    public ResponseObject saveOrUpdate(@Valid @RequestBody PushedMessage PushedMessage) {
        return new SuccessResponse(pushedMessageService.saveOrUpdate(PushedMessage));
    }

    @DeleteMapping("/api/merchant/pushedMessage/{id}")
    public ResponseObject deleteById(@PathVariable("id") long id) {
        return new SuccessResponse(pushedMessageService.deleteById(id));
    }

    @GetMapping("/api/merchant/pushedMessage/searchForConsole")
    public BootstrapTableResult<PushedMessage> searchForConsole(PushedMessageSearchParam PushedMessageSearchParam) {
        Page<PushedMessage> result = pushedMessageService.searchForConsole(PushedMessageSearchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }
}

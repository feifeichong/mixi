package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.MerchantUserType;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.MerchantUserService;
import com.lecotec.mixi.service.MerchantUserTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/merchantUserType")
@Api(tags = "后台用户角色接口")
public class MerchantUserTypeController {

    @Autowired
    private MerchantUserTypeService merchantUserTypeService;

    @Autowired
    private MerchantUserService merchantUserService;

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody MerchantUserType merchantUserType) {
        return new SuccessResponse(merchantUserTypeService.saveOrUpdate(merchantUserType));
    }

    @GetMapping("/list")
    public BootstrapTableResult<MerchantUserType> getAllByPage(int pageNumber, int pageSize) {
        Page<MerchantUserType> result = merchantUserTypeService.getAllByPage(pageNumber, pageSize);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable("id") long id) {
        return merchantUserService.isExistUserByUserTypeId(id)
                ? new FailResponse("当前角色下面还有用户信息")
                : new SuccessResponse(merchantUserTypeService.delete(id));

    }
}
